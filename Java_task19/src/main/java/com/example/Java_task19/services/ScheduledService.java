package com.example.Java_task19.services;

import com.example.Java_task19.dto.WorkerDTO;
import com.example.Java_task19.models.Manufacture;
import com.example.Java_task19.models.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ScheduledService {
    private final ManufactureService manufactureService;
    private final WorkerService workerService;
    private final ModelMapper modelMapper;

    private final String DIRECTORY;

    @Autowired
    public ScheduledService(ManufactureService manufactureService, WorkerService workerService,
                            ModelMapper modelMapper, @Value("${upload.directory-path}") String dir) {
        this.manufactureService = manufactureService;
        this.workerService = workerService;
        this.modelMapper = modelMapper;
        DIRECTORY = dir;
    }

    @Scheduled(cron = "0 30 * * * *")
    public void scheduledTask() throws IOException {
        List<Manufacture> manufactures = manufactureService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        File directory = new File(DIRECTORY);
        for(File x : directory.listFiles())
            x.delete();

        for(Manufacture x : manufactures) {
            String name = "Manufacture " + x.getId() + ".txt";
            File file = new File(directory.getAbsolutePath() + "/" + name);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            fileWriter.write(mapper.writeValueAsString(x));
            fileWriter.flush();
        }

        List<Worker> workers = workerService.findAll();
        for(Worker x : workers) {
            String name = "Worker " + x.getId() + ".txt";
            File file = new File(directory.getAbsolutePath() + "/" + name);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            fileWriter.write(mapper.writeValueAsString(convertToWorkerDTO(x)));
            fileWriter.flush();
        }
    }

    private WorkerDTO convertToWorkerDTO(Worker worker) {
        WorkerDTO workerDTO = modelMapper.map(worker, WorkerDTO.class);
        return workerDTO;
    }
}

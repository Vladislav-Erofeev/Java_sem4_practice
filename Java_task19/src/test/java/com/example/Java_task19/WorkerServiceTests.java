package com.example.Java_task19;

import com.example.Java_task19.models.Worker;
import com.example.Java_task19.repositories.WorkerRepository;
import com.example.Java_task19.services.WorkerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class WorkerServiceTests {
    @Mock
    private WorkerRepository workerRepository;
    @Captor
    private ArgumentCaptor<Worker> captor;

    @Test
    void getWorkers() {
        Worker worker = new Worker();
        worker.setFirstName("Test1");
        Worker worker1 = new Worker();
        worker.setFirstName("Test2");
        Worker worker2 = new Worker();
        worker.setFirstName("Test3");

        Mockito.when(workerRepository.findAll()).thenReturn(List.of(worker, worker1, worker2));
        WorkerService workerService = new WorkerService(workerRepository);

        Assertions.assertEquals(3, workerService.findAll().size());
        Assertions.assertEquals(worker.getFirstName(), workerService.findAll().get(0).getFirstName());
    }

    @Test
    void save() {
        Worker worker = new Worker();
        worker.setFirstName("Test");

        WorkerService service = new WorkerService(workerRepository);
        service.save(worker);
        Mockito.verify(workerRepository).save(captor.capture());
        Worker worker1 = captor.getValue();

        Assertions.assertEquals("Test", worker1.getFirstName());
    }

}

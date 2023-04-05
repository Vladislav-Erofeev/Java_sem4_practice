package com.example.Java_task19;

import com.example.Java_task19.models.Manufacture;
import com.example.Java_task19.models.Worker;
import com.example.Java_task19.repositories.ManufactureRepository;
import com.example.Java_task19.services.ManufactureService;
import com.example.Java_task19.services.WorkerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ManufactureSeviceTests {
    @Mock
    private ManufactureRepository manufactureRepository;


    @Captor
    ArgumentCaptor<Manufacture> captor;

    @Test
    void getManufactures() {
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Test 1");
        Manufacture manufacture1 = new Manufacture();
        manufacture1.setName("Test 1");
        Manufacture manufacture2 = new Manufacture();
        manufacture2.setName("Test 1");

        Mockito.when(manufactureRepository.findAll()).thenReturn(List.of(manufacture, manufacture1, manufacture2));
        ManufactureService service = new ManufactureService(manufactureRepository);
        Assertions.assertEquals(3, service.findAll().size());
        Assertions.assertEquals(manufacture, service.findAll().get(0));
    }

    @Test
    void save() {
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Test 1");

        ManufactureService service = new ManufactureService(manufactureRepository);
        service.save(manufacture);
        Mockito.verify(manufactureRepository).save(captor.capture());
        Manufacture manufacture1 = captor.getValue();

        Assertions.assertEquals("Test 1", manufacture1.getName());
    }
}

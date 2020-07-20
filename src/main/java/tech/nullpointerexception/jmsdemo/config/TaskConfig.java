package tech.nullpointerexception.jmsdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //enables the task Scheduling
@EnableAsync
@Configuration
public class TaskConfig {

    @Bean
    TaskExecutor taskExecutor(){
        //Seteamos un Bean llamado Task Executor.
        return new SimpleAsyncTaskExecutor(); //Implementación Simple de Spring Boot

        /*
        Esto nos dará la habilidad de correr tareas asíncronamente. Y luego el
        @EnableScheduling permitirá que Spring y espere clases para tareas programadas.

        Ahora nos falta setear una tarea programada para enviar un mensaje periódicamente

         */
    }
}

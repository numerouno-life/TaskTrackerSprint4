package taskTracker;

import taskTracker.manager.TaskManager;
import taskTracker.taskData.Epic;
import taskTracker.taskData.Subtask;
import taskTracker.taskData.Task;
import taskTracker.taskData.TaskStatus;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        //Создание задач
        Task task1 = new Task("Задача 1", "Описание задачи 1");
        Task task2 = new Task("Задача 2", "Описание задачи 2");
        taskManager.createTask(task1);
        taskManager.createTask(task2);

        //Создание эпиков
        Epic epic1 = new Epic("Эпик 1", "Описание к эпик 1");
        Epic epic2 = new Epic("Эпик 2", "Описание к эпик 2");
        taskManager.createEpic(epic1);
        taskManager.createEpic(epic2);

        //Создание сабтасков
        Subtask subtask1 = new Subtask("Подзадача 1 к эпику 1", "Описание к подзадаче 1",epic1.getId());
        Subtask subtask2 = new Subtask("Подзадача 2 к эпику 1", "Описание к подзадаче 2",epic1.getId());
        Subtask subtask3 = new Subtask("Подзадача 3 к эпику 2", "Описание к подзадаче 3",epic2.getId());
        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);
        taskManager.createSubtask(subtask3);

        System.out.println("Задачи: ");
        taskManager.getTasks().values().forEach(System.out::println);

        System.out.println("\nЭпики: ");
        taskManager.getEpics().values().forEach(System.out::println);

        System.out.println("\nПодзадачи: ");
        taskManager.getSubtasks().values().forEach(System.out::println);

        //Обновление статусов Задач
        task1.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateTask(task1);
        task2.setStatus(TaskStatus.DONE);
        taskManager.updateTask(task2);

        //Обновление статусов сабтасков
        subtask1.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask1);
        //Обновление статусов сабтасков
        subtask2.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateSubtask(subtask2);
        //Обновление статусов сабтасков
        subtask3.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask3);

        System.out.println("\nЗадачи после обновления статуса: ");
        taskManager.getTasks().values().forEach(System.out::println);

        System.out.println("\nЭпики после обновления статуса: ");
        taskManager.getEpics().values().forEach(System.out::println);

        System.out.println("\nПодзадачи после обновления статуса: ");
        taskManager.getSubtasks().values().forEach(System.out::println);

        //Удаление Задачи и Эпика по ID
        taskManager.deleteTaskById(task1.getId());
        taskManager.deleteEpicById(epic1.getId());

        System.out.println("\nЗадачи после удаления: ");
        taskManager.getTasks().values().forEach(System.out::println);

        System.out.println("\nЭпики после удаления: ");
        taskManager.getEpics().values().forEach(System.out::println);

        System.out.println("\nПодзадачи после удаления: ");
        taskManager.getSubtasks().values().forEach(System.out::println);

    }
}
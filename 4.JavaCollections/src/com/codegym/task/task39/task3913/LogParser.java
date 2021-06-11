package com.codegym.task.task39.task3913;

import com.codegym.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements QLQuery, IPQuery, UserQuery, DateQuery, EventQuery {
    List<LogEntry> logEntries = new ArrayList<>();

    public LogParser(Path logDir) {
        List<String> filePaths;
        if ((filePaths = this.getLogFiles(logDir)) != null) {
            for (String path : filePaths) {
                readFileInto(Paths.get(path), this.logEntries);
            }
        }
    }

    private List<String> getLogFiles(Path path) {
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.map(Path::toString)
                    .filter(f -> f.endsWith(".log"))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println("Folder does not exist");
        }
        return null;
    }

    private void readFileInto(Path logDir, List<LogEntry> logEntries) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(logDir.toString())));
            while (reader.ready()) {
                logEntries.add(new LogEntry(reader.readLine()));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File IO error");
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {

        return this.getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .map(x -> x.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .map(x -> x.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(event))
                .map(x -> x.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.status.equals(status))
                .map(x -> x.ip)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllUsers() {
        return logEntries.stream()
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .map(x -> x.name)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .map(x -> x.event.toString())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.ip.equals(ip))
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getUsersWhoHaveLoggedIn(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.LOGIN))
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getUsersWhoHaveDownloadedPlugin(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.DOWNLOAD_PLUGIN))
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getUsersWhoHaveSentMessages(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.SEND_MESSAGE))
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getUsersWhoHaveAttemptedTasks(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.ATTEMPT_TASK))
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getUsersWhoHaveAttemptedTasks(Date after, Date before, int task) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.ATTEMPT_TASK))
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getUsersWhoHaveCompletedTasks(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.COMPLETE_TASK))
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getUsersWhoHaveCompletedTasks(Date after, Date before, int task) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.COMPLETE_TASK))
                .map(x -> x.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .filter(f -> f.event.equals(event))
                .map(x -> x.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.status.equals(Status.FAILED))
                .map(x -> x.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorOccurred(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.status.equals(Status.ERROR))
                .map(x -> x.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedInFirstTime(String user, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .filter(f -> f.event.equals(Event.LOGIN))
                .map(x -> x.date)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserAttemptedTask(String user, int task, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .filter(f -> f.event.equals(Event.ATTEMPT_TASK))
                .filter(f -> f.task == task)
                .map(x -> x.date)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserCompletedTask(String user, int task, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .filter(f -> f.event.equals(Event.COMPLETE_TASK))
                .filter(f -> f.task == task)
                .map(x -> x.date)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Date> getDatesWhenUserSentMessages(String user, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .filter(f -> f.event.equals(Event.SEND_MESSAGE))
                .map(x -> x.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .filter(f -> f.event.equals(Event.DOWNLOAD_PLUGIN))
                .map(x -> x.date)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfEvents(Date after, Date before) {
        return this.getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .map(x -> x.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.ip.equals(ip))
                .map(x -> x.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.name.equals(user))
                .map(x -> x.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.status.equals(Status.FAILED))
                .map(x -> x.event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.status.equals(Status.ERROR))
                .map(x -> x.event)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptsToCompleteTask(int task, Date after, Date before) {
        return (int) logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.ATTEMPT_TASK))
                .filter(f -> f.task == task)
                .count();
    }

    @Override
    public int getNumberOfSuccessfulAttemptsToCompleteTask(int task, Date after, Date before) {
        return (int) logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.COMPLETE_TASK))
                .filter(f -> f.task == task)
//                .filter(f -> f.status.equals(Status.OK))
                .count();
    }

    @Override
    public Map<Integer, Integer> getAllAttemptedTasksAndNumberOfAttempts(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.ATTEMPT_TASK))
                .collect(Collectors.groupingBy(x -> x.task, Collectors.summingInt(x -> 1)));
    }

    @Override
    public Map<Integer, Integer> getAllCompletedTasksAndNumberOfCompletions(Date after, Date before) {
        return logEntries.stream()
                .filter(f -> f.isInDateRange(after, before))
                .filter(f -> f.event.equals(Event.COMPLETE_TASK))
                .collect(Collectors.groupingBy(x -> x.task, Collectors.summingInt(x -> 1)));
    }

    @Override
    public Set<Object> execute(String query) {
        QLParser<Object> ql = new QLParser<>(query);

        return logEntries.stream()
                .filter(ql::filter)
                .map(ql::mapper)
                .collect(Collectors.toSet());
    }

}
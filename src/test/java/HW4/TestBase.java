package HW4;

import pages.*;

public class TestBase {
    public static  VariableContainer variableContainer = new VariableContainer();
    public static final JiraLoginPage jiraLoginPage = new JiraLoginPage();
    public static final JiraTopPanel jiraTopPanel = new JiraTopPanel();
    public static final JiraOpenTasks jiraOpenTasks = new JiraOpenTasks();
    public static final JiraSearchTask jiraSearchTask = new JiraSearchTask();
    public static final JiraPageVerifier jiraPageVerifier = new JiraPageVerifier();
    public static final JiraCreateProject jiraCreateProject = new JiraCreateProject();

    public final String TASK_SUMMARY = "TEST AT15";
    public final String TASK_DESCRIPTION = "SUPER PUPER DUPER NIGHTMARE FURIOUS DESCRIPTION";

}

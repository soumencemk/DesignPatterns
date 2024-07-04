package proxy;

interface CommandExecutor {
    void runCommand(String cmd) throws Exception;
}

public class Proxy {

    public static void main(String[] args) throws Exception {
        var soumen = new CommandExecutorProxy("soumen", "pass");
        var mita = new CommandExecutorProxy("mita", "pass");
        soumen.runCommand("rm");
        mita.runCommand("rm");
        mita.runCommand("test");
        var other = new CommandExecutorProxy("smen", "ass");
        other.runCommand("hello");
    }
}

class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(String cmd) {
        System.out.println("Command : [" + cmd + "] Executed");
    }
}

class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor commandExecutor;

    CommandExecutorProxy(String user, String password) throws Exception {
        if ("soumen".equals(user) && "pass".equals(password)) {
            isAdmin = true;
            commandExecutor = new CommandExecutorImpl();
        } else if ("mita".equals(user) && "pass".equals(password)) {
            isAdmin = false;
            commandExecutor = new CommandExecutorImpl();
        } else {
            System.err.println("Invalid username/password");
        }
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if(commandExecutor!=null) {
            if (isAdmin) {
                commandExecutor.runCommand(cmd);
            } else {
                if (cmd.trim().startsWith("rm")) {
                    System.err.println("rm command not allowed for non-admin users");
                } else {
                    commandExecutor.runCommand(cmd);
                }
            }
        }else{
            System.err.println("You are not allowed !");
        }

    }
}



/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package Frame;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Objects.VariableHolder;

public class GameOver extends JFrame {

	JPanel pnl = new JPanel();
	VariableHolder hold = new VariableHolder();

	public static final String SUN_JAVA_COMMAND = "sun.java.command";

	public GameOver() {

		JDialog.setDefaultLookAndFeelDecorated(true);
		int response = 0;
		// System.out.println(hold.p1dead + "\t" + hold.p2dead);

		if (hold.p1dead == true) {
			response = JOptionPane.showConfirmDialog(null,
					"The winner is Player 2! Would you like to return to main menu?", "Game Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		} else if (hold.p2dead == true) {
			response = JOptionPane.showConfirmDialog(null,
					"The winner is Player 1! Would you like to return to main menu?", "Game Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}

		if (response == JOptionPane.NO_OPTION) {
			System.exit(0);
		} else if (response == JOptionPane.YES_OPTION) {
			try {
				restartApplication(null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String args[]) {
		// GameOver g = new GameOver();
	}

	public static void restartApplication(Runnable runBeforeRestart) throws IOException {
		try {
			// java binary
			String java = System.getProperty("java.home") + "/bin/java";
			// vm arguments
			List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
			StringBuffer vmArgsOneLine = new StringBuffer();
			for (String arg : vmArguments) {
				// if it's the agent argument : we ignore it otherwise the
				// address of the old application and the new one will be in conflict
				if (!arg.contains("-agentlib")) {
					vmArgsOneLine.append(arg);
					vmArgsOneLine.append(" ");
				}
			}
			// init the command to execute, add the vm args
			final StringBuffer cmd = new StringBuffer("\"" + java + "\" " + vmArgsOneLine);

			// program main and program arguments
			String[] mainCommand = System.getProperty(SUN_JAVA_COMMAND).split(" ");
			// program main is a jar
			if (mainCommand[0].endsWith(".jar")) {
				// if it's a jar, add -jar mainJar
				cmd.append("-jar " + new File(mainCommand[0]).getPath());
			} else {
				// else it's a .class, add the classpath and mainClass
				cmd.append("-cp \"" + System.getProperty("java.class.path") + "\" " + mainCommand[0]);
			}
			// finally add program arguments
			for (int i = 1; i < mainCommand.length; i++) {
				cmd.append(" ");
				cmd.append(mainCommand[i]);
			}
			// execute the command in a shutdown hook, to be sure that all the
			// resources have been disposed before restarting the application
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					try {
						Runtime.getRuntime().exec(cmd.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			// execute some custom code before restarting
			if (runBeforeRestart != null) {
				runBeforeRestart.run();
			}
			// exit
			System.exit(0);
		} catch (Exception e) {
			// something went wrong
			throw new IOException("Error while trying to restart the application", e);
		}
	}

}
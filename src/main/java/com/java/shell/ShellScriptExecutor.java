package com.java.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellScriptExecutor {

	public static void main(String[] args) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("/home/akash/unix_shell_script_tutorial/date.sh");
		
		try {
			Process process = processBuilder.start();
			StringBuilder stringBuilder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(stringBuilder);
				System.exit(0);
			} else {
				//abnormal...
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package controller;

import java.io.*;

public class KillController {
	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		//System.out.println(os);
		return os;
	}
	
	public void listaProcessos() {
		String os = os();
		String[] comd = new String[1];
		
		if (os.contains("Windows")) {
			comd[0] = "TASKLIST /FO TABLE";
			readProcessos(comd);
			
		} else if (os.contains("Linux")) {
			comd[0] = "ps -ef";
			readProcessos(comd);
		
		}
	}
	
	public void mataPid(String pid) {
		String os = os();
		if (os.contains("Windows")) {
			String[] proc = new String[1];
			proc[0] = "TASKLIST /FO TABLE";
			try {
				Process process = Runtime.getRuntime().exec(proc[0]);
				InputStream flow = process.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains(pid)) {
						StringBuffer sBuffer = new StringBuffer();
						sBuffer.append("TASKKILL /PID ");
						sBuffer.append(pid);
						Runtime.getRuntime().exec(sBuffer.toString());
					}
					linha = buffer.readLine();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (os.contains("Linux")) {
			String[] proc = new String[1];
			proc[0] = "ps -ef";
			try {
				Process process = Runtime.getRuntime().exec(proc[0]);
				InputStream flow = process.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains(pid)) {
						StringBuffer sBuffer = new StringBuffer();
						sBuffer.append("kill -9 ");
						sBuffer.append(pid);
						Runtime.getRuntime().exec(sBuffer.toString());
					}
					linha = buffer.readLine();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void mataNome(String nome) {
		String os = os();
		if (os.contains("Windows")) {
			String[] proc = new String[1];
			proc[0] = "TASKLIST /FO TABLE";
			try {
				Process process = Runtime.getRuntime().exec(proc[0]);
				InputStream flow = process.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains(nome)) {
						StringBuffer sBuffer = new StringBuffer();
						sBuffer.append("TASKKILL /IM ");
						sBuffer.append(nome);
						Runtime.getRuntime().exec(sBuffer.toString());
					}
					linha = buffer.readLine();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (os.contains("Linux")) {
			String[] proc = new String[1];
			proc[0] = "ps -ef";
			try {
				Process process = Runtime.getRuntime().exec(proc[0]);
				InputStream flow = process.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains(nome)) {
						StringBuffer sBuffer = new StringBuffer();
						sBuffer.append("pkill -f ");
						sBuffer.append(nome);
						Runtime.getRuntime().exec(sBuffer.toString());
					}
					linha = buffer.readLine();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void readProcessos(String[] proc) {
		try {
			Process process = Runtime.getRuntime().exec(proc[0]);
			InputStream flow = process.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

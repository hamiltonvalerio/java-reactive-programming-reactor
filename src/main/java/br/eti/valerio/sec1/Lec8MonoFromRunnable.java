package br.eti.valerio.sec1;

import br.eti.valerio.util.Util;
import reactor.core.publisher.Mono;

public class Lec8MonoFromRunnable {
	
	public static void main(String[] args) {
		
		
		Mono.fromRunnable(timeConsumingProcess())
				.subscribe(
						Util.onNext(),
						Util.onError(),
						()->{
							System.out.println("Processo concluído! Enviando emails...");
						}
						);
	}
	
	
	private static Runnable timeConsumingProcess() {
		return () -> {
			Util.sleepSeconds(3);
			System.out.println("Operação completa");
		};
	}
	
}

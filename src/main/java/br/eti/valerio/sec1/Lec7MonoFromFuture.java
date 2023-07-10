package br.eti.valerio.sec1;

import java.util.concurrent.CompletableFuture;

import br.eti.valerio.util.Util;
import reactor.core.publisher.Mono;

public class Lec7MonoFromFuture {

	public static void main(String[] args) {
		
		Mono.fromFuture(getName())
					.subscribe(Util.onNext());
		Util.sleepSeconds(1);
	}
	
	private static CompletableFuture<String> getName(){
		return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
	}

}

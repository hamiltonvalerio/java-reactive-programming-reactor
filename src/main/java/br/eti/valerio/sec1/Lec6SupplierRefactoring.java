package br.eti.valerio.sec1;

import br.eti.valerio.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec6SupplierRefactoring {

	public static void main(String[] args) {
		/*
		 * getName(); getName() .subscribeOn(Schedulers.boundedElastic())
		 * .subscribe(Util.onNext()); getName(); Util.sleepSeconds(4);
		 */		
		getName();
		String name = getName()
		.subscribeOn(Schedulers.boundedElastic())
		.block(); //.block() não é uma boa prática
		System.out.println(name);
		getName();
		Util.sleepSeconds(4);
	}
	
	private static Mono<String> getName() {
		
		System.out.println("entered getName method");
		
		return Mono.fromSupplier(() -> {
			System.out.println("Gerando nome...");
			Util.sleepSeconds(3);
			return Util.faker().name().fullName();
		}).map(String::toUpperCase);
	}

}

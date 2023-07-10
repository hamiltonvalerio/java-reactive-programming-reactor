package br.eti.valerio.sec1;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import br.eti.valerio.util.Util;
import reactor.core.publisher.Mono;

public class Lec5MonoFromSupplier {

	public static void main(String[] args) {

		// use just only when you have data already
		// Mono<String> mono = Mono.just(getName());
		Supplier<String> stringSupplier = () -> getName();
		Mono<String> mono = Mono.fromSupplier(stringSupplier);
		mono.subscribe(Util.onNext());

		Callable<String> stringCallable = () -> getName();
		Mono.fromCallable(stringCallable).subscribe(Util.onNext());
	}

	private static String getName() {
		System.out.println("Gerando nome...");
		return Util.faker().name().fullName();
	}

}

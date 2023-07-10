package br.eti.valerio.sec1;

import br.eti.valerio.util.Util;
import reactor.core.publisher.Mono;

public class Lec3MonoSubscribe {

	public static void main(String[] args) {
		
		Mono<Integer> mono = Mono.just("string")
				.map(String::length)
				.map(l -> l /0);

		/*mono.subscribe(
				item -> System.out.println(item),
				err -> System.out.println(err.getMessage()),
				() -> System.out.println("Completed")
		);*/
		
		mono.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete()
		);

	}

}

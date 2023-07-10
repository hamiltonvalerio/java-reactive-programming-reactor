package br.eti.valerio.sec1;

import br.eti.valerio.util.Util;
import reactor.core.publisher.Mono;

public class Lec4MonoEmptyOrError {

	public static void main(String[] args) {
		
		userRepository(3)
		.subscribe(
					Util.onNext(),
					Util.onError(),
					Util.onComplete()
				);
		
		
	}

	//publisher
	private static Mono<String> userRepository(int userId){
		
		if(userId == 1) {
			return Mono.just(Util.faker().name().firstName());
		}else if(userId == 2){
			return Mono.empty();
		}else {
			return Mono.error(new RuntimeException("Nada no range"));
		}
	}
}

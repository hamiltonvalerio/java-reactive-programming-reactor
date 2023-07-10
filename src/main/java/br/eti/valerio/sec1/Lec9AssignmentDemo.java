package br.eti.valerio.sec1;

import br.eti.valerio.sec1.assignment.FileService;
import br.eti.valerio.util.Util;

public class Lec9AssignmentDemo {

	public static void main(String[] args) {
		
		FileService.read("file3.txt")
			.subscribe(
					Util.onNext(),
					Util.onError(),
					Util.onComplete()
					);
		
		/*FileService.write("file3.txt", "Arquivo 3")
		.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete()
				);*/
	
		
		FileService.delete("file3.txt")
		.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete()
				);
	}

}

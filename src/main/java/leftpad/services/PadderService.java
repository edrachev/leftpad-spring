package leftpad.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PadderService {
	public String pad(String input) {
		return StringUtils.leftPad(input, 10, "*");
	}

	public CompletionStage<String> padAsync(String str) {
		return CompletableFuture.supplyAsync(() -> {
			String paddedString = StringUtils.leftPad(str, 10, "*");
			return paddedString;
		});
	}
}

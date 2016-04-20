package leftpad.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PadderService {
    public String pad(String input) {
	return StringUtils.leftPad(input, 10, "*");
    } 
}

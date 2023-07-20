package servlets.dto;

import lombok.Builder;
import lombok.Value;

/**
 * @author Oksana Poliakova on 20.07.2023
 * @projectName MavenApache
 */

@Value
@Builder
public class UserDto {
    Long id;
    String mail;
}

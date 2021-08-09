package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AddPlayerValidation
public class UpdateWithExistingPlayerCommand {

    private long id;

}

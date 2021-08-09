package org.training360.finalexam.players;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddPlayerValidator implements ConstraintValidator<AddPlayerValidation,UpdateWithExistingPlayerCommand> {

    @Autowired
    private PlayerService playerService;

    @Override
    public boolean isValid(UpdateWithExistingPlayerCommand command, ConstraintValidatorContext constraintValidatorContext) {

        PlayerDTO player = playerService.findPlayerById(command.getId());

        return player.getTeam()==null;
    }
}

package seedu.address.logic.commands;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import static java.util.Objects.requireNonNull;

/**
 * Show the courier his/her delivery statistics
 * with the given date provided in the command
 *
 * @author Amos Cheong Jit Hon
 */
public class ShowCommand extends Command {

    public static final String COMMAND_WORD = "show";

    public static final String MESSAGE_USAGE = "Example: " + COMMAND_WORD + " START_DATE " + "END_DATE \n"
            + "START_DATE should be before or equals to the END_DATE";

    public static final String SHOW_MESSAGE = "Showing your delivery statistics";

    public static final String PARSE_DATE_ERROR_MESSAGE = "Please provide a valid date! \n";

    public static final String ILLEGAL_ARGUMENT = "Please provide exactly two dates. \n";

    public static final String WRONG_DATE_ORDER = "The Start Date should not be after than the End Date! \n";

    private static final String TODAY = "today";

    private static final String ALL = "all";

    public static final String MESSAGE_TODAY = " for " + TODAY;

    public static final String MESSAGE_ALL = " for all the lists";

    public static final String MESSAGE_INCLUSIVE = " within the given dates (including the start and end dates)";
    private String intendedMessage;

    private boolean isCommandSuccessful;

    private static LocalDate DATE_TODAY = LocalDate.now();

    public static LocalDate startDate;

    public static LocalDate endDate;

    public static boolean showAll;

    private String argument;

    public static final DateTimeFormatter FORMAT_CHECKER = DateTimeFormatter
            .ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);

    public ShowCommand(String arguments) {
        // Reset if it was initialized
        // previously
        showAll = false;

        String argumentTrimmed = arguments.trim();
        argument = argumentTrimmed;
        requireNonNull(argumentTrimmed);
        if (isToday(argumentTrimmed)){
            intendedMessage = SHOW_MESSAGE + MESSAGE_TODAY;
            isCommandSuccessful = true;
            startDate = DATE_TODAY;
            endDate = DATE_TODAY;
        } else if (isAll(argumentTrimmed)) {
            intendedMessage = SHOW_MESSAGE + MESSAGE_ALL;
            isCommandSuccessful = true;
        } else {
            String[] arrOfDate = argumentTrimmed.replaceAll("\\s+", " ").split("\\s");

            try {
                if (arrOfDate.length != 2) {
                    throw new ParseException(ILLEGAL_ARGUMENT);
                }
                startDate = LocalDate.parse(arrOfDate[0], FORMAT_CHECKER);
                endDate = LocalDate.parse(arrOfDate[1], FORMAT_CHECKER);

                if (startDate.compareTo(endDate) > 0) {
                    throw new ParseException(WRONG_DATE_ORDER);
                }
                intendedMessage = startDate.compareTo(endDate) == 0
                        ? SHOW_MESSAGE + MESSAGE_TODAY
                        : SHOW_MESSAGE + MESSAGE_INCLUSIVE;
                isCommandSuccessful = true;
            } catch (DateTimeParseException ex) {
                intendedMessage = PARSE_DATE_ERROR_MESSAGE + MESSAGE_USAGE;
                isCommandSuccessful = false;
            } catch (ParseException pex) {
                intendedMessage = pex.getMessage() + MESSAGE_USAGE;
                isCommandSuccessful = false;
            }
        }
    }

    public boolean isToday(String arguments) {
        return arguments.equals(TODAY);
    }

    public static boolean isAll() {
        return showAll;
    }

    public static boolean isAll(String arguments) {
        showAll = arguments.equals(ALL);
        return showAll;
    }

    public static LocalDate getStartDate() {
        return startDate;
    }

    public static LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(intendedMessage, false, false, false, isCommandSuccessful);
    }
}

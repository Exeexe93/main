package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COMMENT_NIL;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COD_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COD_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIMESTAMP_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIMESTAMP_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WAREHOUSE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WAREHOUSE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TID_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TID_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.OrderBook;
import seedu.address.model.order.Order;

/**
 * A utility class containing a list of {@code Order} objects to be used in tests.
 */
public class TypicalOrders {

    public static final Order ALICE = new OrderBuilder().withName("Alice Pauline")
            .withTID("A00000000")
            .withAddress("123, Jurong West Ave 6, #08-111")
            .withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831")
            .withCash("$1")
            .withPhone("94351253")
            .withTags("friends").build();
    public static final Order BENSON = new OrderBuilder().withName("Benson Meier")
            .withTID("A00000001")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831")
            .withCash("$1")
            .withComment("NIL").withTags("owesMoney", "friends").build();
    public static final Order CARL = new OrderBuilder().withName("Carl Kurz").withPhone("95352563")
            .withTID("A00000002")
            .withCash("$1").withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831").build();
    public static final Order DANIEL = new OrderBuilder().withName("Daniel Meier").withPhone("87652533")
            .withTID("A00000003")
            .withCash("$1").withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831").withTags("friends").build();
    public static final Order ELLE = new OrderBuilder().withName("Elle Meyer").withPhone("9482224")
            .withTID("A00000004")
            .withCash("$1").withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831").build();
    public static final Order FIONA = new OrderBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withTID("A00000005")
            .withCash("$1").withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831").build();
    public static final Order GEORGE = new OrderBuilder().withName("George Best").withPhone("9482442")
            .withTID("A00000006")
            .withCash("$1").withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831").build();

    // Manually added
    public static final Order HOON = new OrderBuilder().withName("Hoon Meier").withPhone("8482424")
            .withTID("A00000007")
            .withCash("$1").withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831").build();
    public static final Order IDA = new OrderBuilder().withName("Ida Mueller").withPhone("8482131")
            .withTID("A10000005")
            .withCash("$1").withTimeStamp("2020-02-20 1500")
            .withWarehouse("5 Toh Guan Rd E, #02-30 S608831").build();

    // Manually added - Order's details found in {@code CommandTestUtil}
    public static final Order AMY = new OrderBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withTID(VALID_TID_AMY).withAddress(VALID_ADDRESS_AMY).withTimeStamp(VALID_TIMESTAMP_AMY)
            .withCash(VALID_COD_AMY)
            .withComment(VALID_COMMENT_NIL).withWarehouse(VALID_WAREHOUSE_AMY)
            .withTags(VALID_TAG_FRIEND).build();
    public static final Order BOB = new OrderBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withTID(VALID_TID_BOB).withAddress(VALID_ADDRESS_BOB).withTimeStamp(VALID_TIMESTAMP_BOB)
            .withCash(VALID_COD_BOB)
            .withWarehouse(VALID_WAREHOUSE_BOB)
            .withComment(VALID_COMMENT_NIL).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalOrders() {} // prevents instantiation

    /**
     * Returns an {@code OrderBook} with all the typical orders.
     */
    public static OrderBook getTypicalOrderBook() {
        OrderBook ab = new OrderBook();
        for (Order order : getTypicalOrders()) {
            ab.addOrder(order);
        }
        return ab;
    }

    public static List<Order> getTypicalOrders() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}

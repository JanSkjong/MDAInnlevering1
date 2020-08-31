/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jansk
 */
/** Represents a photo or an image of an item for sale */
public class Photo {}
/** An item to be sold in the Fant webstore */
public class Item {}
/** Represents an user in the Fant webstore */
public class User {}
/** REST service class to be used by the UI */
public class FantService {
/**
* Public method that returns items with photos sold in the shop
*/
public List<Item> getItems() {
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getAllItems() {
    List<Item> items = ItemRepository.getAllItems(); //queries database for all items
    }
}
/**
* A registered user may purchase an Item. An email will be sent to the
* seller if the purchase is successful
*
* @param itemid unique id for item
* @return result of purchase request
*/
public Response purchase(Long itemid) {}
 /**
 * A registered user may remove an item and associated photos owned by the
 * calling user. An user with administrator privileges may remove any item
 * and associated photos.
 *
 * @param itemid unique id for item to be deleted
 * @return result of delete request
 */
public Response delete(Long itemid) {
    @Delete
    @PATH("{itemid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("itemid") String itemid) {
        Item item = itemRepository.deleteItemByItemid(itemid);
        return Response.ok(item).build();
    }
}
/**
 * A registered user may add an item and photo(s) to Fant.
 *
 * @param title the title of Item
 * @param description the description of Item
 * @param price the price of Item
 * @param photos one or more photos associated with Item
 * @return result of the request. If successful, the request will include
 * the new unique ids of the Item and associated Photos
 */
 public Response addItem(String title, String description, BigDecimal price,
 FormDataMultiPart photos) {
    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response saveItem(Item item) {
        item = itemRepository.saveItem(item);
        return Response.ok(item).build();
    }
 }
 /**
 * Streams an image to the browser (the actual compressed pixels). The image
 * will be scaled to the appropriate width if the width parameter is provided.
 * This is a public method available to all callers.
 *
 * @param name the filename of the image
 * @param width the required scaled with of the image
 *
 * @return the image in original format or in jpeg if scaled
 */
 public Response getPhoto(String name, int width) {}
}
/** REST service class used for authentication */
public class AuthenticationService {
 public Response login(String userid, String password) {} // Login user
 public Response createUser(String userid, String password) {} // Create new user
 public User getCurrentUser() {} // Get information about current user
 /** Change password of current user or any user if current user has the role of
 administrator */
 public Response changePassword(String userid, String password) {}
}

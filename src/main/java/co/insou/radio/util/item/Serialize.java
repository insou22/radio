package co.insou.radio.util.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Serialize {

    /**
     * Serializes an ItemStack Array to a string.
     *
     * @param iss The ItemStack Array
     * @return The unencoded serialized string
     */
    public static String serialize(ItemStack... iss) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream)) {
            dataOutput.writeInt(iss.length);
            for (ItemStack item : iss) {
                dataOutput.writeObject(item);
            }
            return new String(outputStream.toByteArray());
        } catch (IOException e) {
            throw new IllegalStateException("Unable to save item stacks.", e);
        }
    }

    /**
     * Deserializes a String into an ItemStack Array. The string must not be
     * encoded!
     *
     * @param data The data string, must not be encoded
     * @return The ItemStack Array
     * @throws IOException Thrown when there is an IOError
     */
    public static ItemStack[] deserialize(String data) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        ItemStack[] iss = null;
        try (BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream)) {
            iss = new ItemStack[dataInput.readInt()];
            for (int i = 0; i < iss.length; i++) {
                iss[i] = (ItemStack) dataInput.readObject();
            }
        } catch (ClassNotFoundException ex) {
            throw new IOException("Unable to decode class type.", ex);
        }
        return iss;
    }

}

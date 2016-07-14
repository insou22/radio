package co.insou.radio.util.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class Skulls {

    private static final String ARROW_LEFT_URL = "http://textures.minecraft.net/texture/f2599bd986659b8ce2c4988525c94e19ddd39fad08a38284a197f1b70675acc";
    private static final String ARROW_RIGHT_URL = "http://textures.minecraft.net/texture/c2f910c47da042e4aa28af6cc81cf48ac6caf37dab35f88db993accb9dfe516";
    private static final String PAUSE_URL = "http://textures.minecraft.net/texture/ec2eb921628e4e38c9d9da39bba577da6dbfe08f10993fec8c8155aaaf976";
    private static final String PLAY_URL = "http://textures.minecraft.net/texture/4ae29422db4047efdb9bac2cdae5a0719eb772fccc88a66d912320b343c341";
    private static final String REPEAT_URL = "http://textures.minecraft.net/texture/bc8def67a12622ead1decd3d89364257b531896d87e469813131ca235b5c7";
    private static final String SHUFFLE_URL = "http://textures.minecraft.net/texture/4b92cb43333aa621c70eef4ebf299ba412b446fe12e341ccc582f3192189";
    private static final String SCREEN_URL = "http://textures.minecraft.net/texture/fcaf4473372364426444e49676f6e3372438afa3a6eb04a38af8e412965c1b8";

    private static ItemStack ARROW_LEFT;
    private static ItemStack ARROW_RIGHT;
    private static ItemStack PAUSE;
    private static ItemStack PLAY;
    private static ItemStack REPEAT;
    private static ItemStack SHUFFLE;
    private static ItemStack SCREEN;

    public static void loadItems() {
        ARROW_LEFT = loadItem(ARROW_LEFT_URL);
        ARROW_RIGHT = loadItem(ARROW_RIGHT_URL);
        PAUSE = loadItem(PAUSE_URL);
        PLAY = loadItem(PLAY_URL);
        REPEAT = loadItem(REPEAT_URL);
        SHUFFLE = loadItem(SHUFFLE_URL);
        SCREEN = loadItem(SCREEN_URL);
    }

    public static ItemStack loadItem(String url) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if(url.isEmpty())return head;


        SkullMeta headMeta = (SkullMeta) head.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public static ItemStack getArrowLeft() {
        return ARROW_LEFT.clone();
    }

    public static ItemStack getArrowRight() {
        return ARROW_RIGHT.clone();
    }

    public static ItemStack getPause() {
        return PAUSE.clone();
    }

    public static ItemStack getPlay() {
        return PLAY.clone();
    }

    public static ItemStack getRepeat() {
        return REPEAT.clone();
    }

    public static ItemStack getShuffle() {
        return SHUFFLE.clone();
    }

    public static ItemStack getScreen() {
        return SCREEN.clone();
    }


}

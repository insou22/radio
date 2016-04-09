package co.insou.radio.util.item;

import org.bukkit.Material;

public class MaterialName {

    public static String getName(Material material, short durability) {
        switch(material.getId()) {
            case 0:
                return "Air";
            case 1:
                switch(durability) {
                    case 0:
                        return "Stone";
                    case 1:
                        return "Granite";
                    case 2:
                        return "Polished Granite";
                    case 3:
                        return "Diorite";
                    case 4:
                        return "Polished Diorite";
                    case 5:
                        return "Andesite";
                    case 6:
                        return "Polished Andesite";
                }
                return "Stone";
            case 2:
                return "Grass";
            case 3:
                switch(durability) {
                    case 0:
                        return "Dirt";
                    case 1:
                        return "Coarse Dirt";
                    case 2:
                        return "Podzol";
                }
                return "Dirt";
            case 4:
                return "Cobblestone";
            case 5:
                switch(durability) {
                    case 0:
                        return "Oak Wood Plank";
                    case 1:
                        return "Spruce Wood Plank";
                    case 2:
                        return "Birch Wood Plank";
                    case 3:
                        return "Jungle Wood Plank";
                    case 4:
                        return "Acacia Wood Plank";
                    case 5:
                        return "Dark Oak Wood Plank";
                }
                return "Oak Wood Plank";
            case 6:
                switch(durability) {
                    case 0:
                        return "Oak Sapling";
                    case 1:
                        return "Spruce Sapling";
                    case 2:
                        return "Birch Sapling";
                    case 3:
                        return "Jungle Sapling";
                    case 4:
                        return "Acacia Sapling";
                    case 5:
                        return "Dark Oak Sapling";
                }
                return "Oak Sapling";
            case 7:
                return "Bedrock";
            case 8:
                return "Flowing Water";
            case 9:
                return "Still Water";
            case 10:
                return "Flowing Lava";
            case 11:
                return "Still Lava";
            case 12:
                switch(durability) {
                    case 0:
                        return "Sand";
                    case 1:
                        return "Red Sand";
                }
                return "Sand";
            case 13:
                return "Gravel";
            case 14:
                return "Gold Ore";
            case 15:
                return "Iron Ore";
            case 16:
                return "Coal Ore";
            case 17:
                switch(durability) {
                    case 0:
                        return "Oak Wood";
                    case 1:
                        return "Spruce Wood";
                    case 2:
                        return "Birch Wood";
                    case 3:
                        return "Jungle Wood";
                }
                return "Oak Wood";
            case 18:
                switch(durability) {
                    case 0:
                        return "Oak Leaves";
                    case 1:
                        return "Spruce Leaves";
                    case 2:
                        return "Birch Leaves";
                    case 3:
                        return "Jungle Leaves";
                }
                return "Oak Leaves";
            case 19:
                switch(durability) {
                    case 0:
                        return "Sponge";
                    case 1:
                        return "Wet Sponge";
                }
                return "Sponge";
            case 20:
                return "Glass";
            case 21:
                return "Lapis Lazuli Ore";
            case 22:
                return "Lapis Lazuli Block";
            case 23:
                return "Dispenser";
            case 24:
                switch(durability) {
                    case 0:
                        return "Sandstone";
                    case 1:
                        return "Chiseled Sandstone";
                    case 2:
                        return "Smooth Sandstone";
                }
                return "Sandstone";
            case 25:
                return "Note Block";
            case 26:
                return "Bed";
            case 27:
                return "Powered Rail";
            case 28:
                return "Detector Rail";
            case 29:
                return "Sticky Piston";
            case 30:
                return "Cobweb";
            case 31:
                switch(durability) {
                    case 0:
                        return "Dead Shrub";
                    case 1:
                        return "Grass";
                    case 2:
                        return "Fern";
                }
                return "Dead Shrub";
            case 32:
                return "Dead Bush";
            case 33:
                return "Piston";
            case 34:
                return "Piston Head";
            case 35:
                switch(durability) {
                    case 0:
                        return "White Wool";
                    case 1:
                        return "Orange Wool";
                    case 2:
                        return "Magenta Wool";
                    case 3:
                        return "Light Blue Wool";
                    case 4:
                        return "Yellow Wool";
                    case 5:
                        return "Lime Wool";
                    case 6:
                        return "Pink Wool";
                    case 7:
                        return "Gray Wool";
                    case 8:
                        return "Light Gray Wool";
                    case 9:
                        return "Cyan Wool";
                    case 10:
                        return "Purple Wool";
                    case 11:
                        return "Blue Wool";
                    case 12:
                        return "Brown Wool";
                    case 13:
                        return "Green Wool";
                    case 14:
                        return "Red Wool";
                    case 15:
                        return "Black Wool";
                }
                return "White Wool";
            case 37:
                return "Dandelion";
            case 38:
                switch(durability) {
                    case 0:
                        return "Poppy";
                    case 1:
                        return "Blue Orchid";
                    case 2:
                        return "Allium";
                    case 3:
                        return "Azure Bluet";
                    case 4:
                        return "Red Tulip";
                    case 5:
                        return "Orange Tulip";
                    case 6:
                        return "White Tulip";
                    case 7:
                        return "Pink Tulip";
                    case 8:
                        return "Oxeye Daisy";
                }
                return "Poppy";
            case 39:
                return "Brown Mushroom";
            case 40:
                return "Red Mushroom";
            case 41:
                return "Gold Block";
            case 42:
                return "Iron Block";
            case 43:
                switch(durability) {
                    case 0:
                        return "Double Stone Slab";
                    case 1:
                        return "Double Sandstone Slab";
                    case 2:
                        return "Double Wooden Slab";
                    case 3:
                        return "Double Cobblestone Slab";
                    case 4:
                        return "Double Brick Slab";
                    case 5:
                        return "Double Stone Brick Slab";
                    case 6:
                        return "Double Nether Brick Slab";
                    case 7:
                        return "Double Quartz Slab";
                }
                return "Double Stone Slab";
            case 44:
                switch(durability) {
                    case 0:
                        return "Stone Slab";
                    case 1:
                        return "Sandstone Slab";
                    case 2:
                        return "Wooden Slab";
                    case 3:
                        return "Cobblestone Slab";
                    case 4:
                        return "Brick Slab";
                    case 5:
                        return "Stone Brick Slab";
                    case 6:
                        return "Nether Brick Slab";
                    case 7:
                        return "Quartz Slab";
                }
                return "Stone Slab";
            case 45:
                return "Bricks";
            case 46:
                return "TNT";
            case 47:
                return "Bookshelf";
            case 48:
                return "Moss Stone";
            case 49:
                return "Obsidian";
            case 50:
                return "Torch";
            case 51:
                return "Fire";
            case 52:
                return "Monster Spawner";
            case 53:
                return "Oak Wood Stairs";
            case 54:
                return "Chest";
            case 55:
                return "Redstone Wire";
            case 56:
                return "Diamond Ore";
            case 57:
                return "Diamond Block";
            case 58:
                return "Crafting Table";
            case 59:
                return "Wheat Crops";
            case 60:
                return "Farmland";
            case 61:
                return "Furnace";
            case 62:
                return "Burning Furnace";
            case 63:
                return "Standing Sign Block";
            case 64:
                return "Oak Door Block";
            case 65:
                return "Ladder";
            case 66:
                return "Rail";
            case 67:
                return "Cobblestone Stairs";
            case 68:
                return "Wall-mounted Sign Block";
            case 69:
                return "Lever";
            case 70:
                return "Stone Pressure Plate";
            case 71:
                return "Iron Door Block";
            case 72:
                return "Wooden Pressure Plate";
            case 73:
                return "Redstone Ore";
            case 74:
                return "Glowing Redstone Ore";
            case 75:
                return "Redstone Torch (off)";
            case 76:
                return "Redstone Torch (on)";
            case 77:
                return "Stone Button";
            case 78:
                return "Snow";
            case 79:
                return "Ice";
            case 80:
                return "Snow Block";
            case 81:
                return "Cactus";
            case 82:
                return "Clay";
            case 83:
                return "Sugar Canes";
            case 84:
                return "Jukebox";
            case 85:
                return "Oak Fence";
            case 86:
                return "Pumpkin";
            case 87:
                return "Netherrack";
            case 88:
                return "Soul Sand";
            case 89:
                return "Glowstone";
            case 90:
                return "Nether Portal";
            case 91:
                return "Jack o'Lantern";
            case 92:
                return "Cake Block";
            case 93:
                return "Redstone Repeater Block (off)";
            case 94:
                return "Redstone Repeater Block (on)";
            case 95:
                switch(durability) {
                    case 0:
                        return "White Stained Glass";
                    case 1:
                        return "Orange Stained Glass";
                    case 2:
                        return "Magenta Stained Glass";
                    case 3:
                        return "Light Blue Stained Glass";
                    case 4:
                        return "Yellow Stained Glass";
                    case 5:
                        return "Lime Stained Glass";
                    case 6:
                        return "Pink Stained Glass";
                    case 7:
                        return "Gray Stained Glass";
                    case 8:
                        return "Light Gray Stained Glass";
                    case 9:
                        return "Cyan Stained Glass";
                    case 10:
                        return "Purple Stained Glass";
                    case 11:
                        return "Blue Stained Glass";
                    case 12:
                        return "Brown Stained Glass";
                    case 13:
                        return "Green Stained Glass";
                    case 14:
                        return "Red Stained Glass";
                    case 15:
                        return "Black Stained Glass";
                }
                return "White Stained Glass";
            case 96:
                return "Wooden Trapdoor";
            case 97:
                switch(durability) {
                    case 0:
                        return "Stone Monster Egg";
                    case 1:
                        return "Cobblestone Monster Egg";
                    case 2:
                        return "Stone Brick Monster Egg";
                    case 3:
                        return "Mossy Stone Brick Monster Egg";
                    case 4:
                        return "Cracked Stone Brick Monster Egg";
                    case 5:
                        return "Chiseled Stone Brick Monster Egg";
                }
                return "Stone Monster Egg";
            case 98:
                switch(durability) {
                    case 0:
                        return "Stone Bricks";
                    case 1:
                        return "Mossy Stone Bricks";
                    case 2:
                        return "Cracked Stone Bricks";
                    case 3:
                        return "Chiseled Stone Bricks";
                }
                return "Stone Bricks";
            case 99:
                return "Brown Mushroom Block";
            case 100:
                return "Red Mushroom Block";
            case 101:
                return "Iron Bars";
            case 102:
                return "Glass Pane";
            case 103:
                return "Melon Block";
            case 104:
                return "Pumpkin Stem";
            case 105:
                return "Melon Stem";
            case 106:
                return "Vines";
            case 107:
                return "Oak Fence Gate";
            case 108:
                return "Brick Stairs";
            case 109:
                return "Stone Brick Stairs";
            case 110:
                return "Mycelium";
            case 111:
                return "Lily Pad";
            case 112:
                return "Nether Brick";
            case 113:
                return "Nether Brick Fence";
            case 114:
                return "Nether Brick Stairs";
            case 115:
                return "Nether Wart";
            case 116:
                return "Enchantment Table";
            case 117:
                return "Brewing Stand";
            case 118:
                return "Cauldron";
            case 119:
                return "End Portal";
            case 120:
                return "End Portal Frame";
            case 121:
                return "End Stone";
            case 122:
                return "Dragon Egg";
            case 123:
                return "Redstone Lamp (inactive)";
            case 124:
                return "Redstone Lamp (active)";
            case 125:
                switch(durability) {
                    case 0:
                        return "Double Oak Wood Slab";
                    case 1:
                        return "Double Spruce Wood Slab";
                    case 2:
                        return "Double Birch Wood Slab";
                    case 3:
                        return "Double Jungle Wood Slab";
                    case 4:
                        return "Double Acacia Wood Slab";
                    case 5:
                        return "Double Dark Oak Wood Slab";
                }
                return "Double Oak Wood Slab";
            case 126:
                switch(durability) {
                    case 0:
                        return "Oak Wood Slab";
                    case 1:
                        return "Spruce Wood Slab";
                    case 2:
                        return "Birch Wood Slab";
                    case 3:
                        return "Jungle Wood Slab";
                    case 4:
                        return "Acacia Wood Slab";
                    case 5:
                        return "Dark Oak Wood Slab";
                }
                return "Oak Wood Slab";
            case 127:
                return "Cocoa";
            case 128:
                return "Sandstone Stairs";
            case 129:
                return "Emerald Ore";
            case 130:
                return "Ender Chest";
            case 131:
                return "Tripwire Hook";
            case 132:
                return "Tripwire";
            case 133:
                return "Emerald Block";
            case 134:
                return "Spruce Wood Stairs";
            case 135:
                return "Birch Wood Stairs";
            case 136:
                return "Jungle Wood Stairs";
            case 137:
                return "Command Block";
            case 138:
                return "Beacon";
            case 139:
                switch(durability) {
                    case 0:
                        return "Cobblestone Wall";
                    case 1:
                        return "Mossy Cobblestone Wall";
                }
                return "Cobblestone Wall";
            case 140:
                return "Flower Pot";
            case 141:
                return "Carrots";
            case 142:
                return "Potatoes";
            case 143:
                return "Wooden Button";
            case 144:
                return "Mob Head";
            case 145:
                return "Anvil";
            case 146:
                return "Trapped Chest";
            case 147:
                return "Weighted Pressure Plate (light)";
            case 148:
                return "Weighted Pressure Plate (heavy)";
            case 149:
                return "Redstone Comparator (inactive)";
            case 150:
                return "Redstone Comparator (active)";
            case 151:
                return "Daylight Sensor";
            case 152:
                return "Redstone Block";
            case 153:
                return "Nether Quartz Ore";
            case 154:
                return "Hopper";
            case 155:
                switch(durability) {
                    case 0:
                        return "Quartz Block";
                    case 1:
                        return "Chiseled Quartz Block";
                    case 2:
                        return "Pillar Quartz Block";
                }
                return "Quartz Block";
            case 156:
                return "Quartz Stairs";
            case 157:
                return "Activator Rail";
            case 158:
                return "Dropper";
            case 159:
                switch(durability) {
                    case 0:
                        return "White Stained Clay";
                    case 1:
                        return "Orange Stained Clay";
                    case 2:
                        return "Magenta Stained Clay";
                    case 3:
                        return "Light Blue Stained Clay";
                    case 4:
                        return "Yellow Stained Clay";
                    case 5:
                        return "Lime Stained Clay";
                    case 6:
                        return "Pink Stained Clay";
                    case 7:
                        return "Gray Stained Clay";
                    case 8:
                        return "Light Gray Stained Clay";
                    case 9:
                        return "Cyan Stained Clay";
                    case 10:
                        return "Purple Stained Clay";
                    case 11:
                        return "Blue Stained Clay";
                    case 12:
                        return "Brown Stained Clay";
                    case 13:
                        return "Green Stained Clay";
                    case 14:
                        return "Red Stained Clay";
                    case 15:
                        return "Black Stained Clay";
                }
                return "White Stained Clay";
            case 160:
                switch(durability) {
                    case 0:
                        return "White Stained Glass Pane";
                    case 1:
                        return "Orange Stained Glass Pane";
                    case 2:
                        return "Magenta Stained Glass Pane";
                    case 3:
                        return "Light Blue Stained Glass Pane";
                    case 4:
                        return "Yellow Stained Glass Pane";
                    case 5:
                        return "Lime Stained Glass Pane";
                    case 6:
                        return "Pink Stained Glass Pane";
                    case 7:
                        return "Gray Stained Glass Pane";
                    case 8:
                        return "Light Gray Stained Glass Pane";
                    case 9:
                        return "Cyan Stained Glass Pane";
                    case 10:
                        return "Purple Stained Glass Pane";
                    case 11:
                        return "Blue Stained Glass Pane";
                    case 12:
                        return "Brown Stained Glass Pane";
                    case 13:
                        return "Green Stained Glass Pane";
                    case 14:
                        return "Red Stained Glass Pane";
                    case 15:
                        return "Black Stained Glass Pane";
                }
                return "White Stained Glass Pane";
            case 161:
                switch(durability) {
                    case 0:
                        return "Acacia Leaves";
                    case 1:
                        return "Dark Oak Leaves";
                }
                return "Acacia Leaves";
            case 162:
                switch(durability) {
                    case 0:
                        return "Acacia Wood";
                    case 1:
                        return "Dark Oak Wood";
                }
                return "Acacia Wood";
            case 163:
                return "Acacia Wood Stairs";
            case 164:
                return "Dark Oak Wood Stairs";
            case 165:
                return "Slime Block";
            case 166:
                return "Barrier";
            case 167:
                return "Iron Trapdoor";
            case 168:
                switch(durability) {
                    case 0:
                        return "Prismarine";
                    case 1:
                        return "Prismarine Bricks";
                    case 2:
                        return "Dark Prismarine";
                }
                return "Prismarine";
            case 169:
                return "Sea Lantern";
            case 170:
                return "Hay Bale";
            case 171:
                switch(durability) {
                    case 0:
                        return "White Carpet";
                    case 1:
                        return "Orange Carpet";
                    case 2:
                        return "Magenta Carpet";
                    case 3:
                        return "Light Blue Carpet";
                    case 4:
                        return "Yellow Carpet";
                    case 5:
                        return "Lime Carpet";
                    case 6:
                        return "Pink Carpet";
                    case 7:
                        return "Gray Carpet";
                    case 8:
                        return "Light Gray Carpet";
                    case 9:
                        return "Cyan Carpet";
                    case 10:
                        return "Purple Carpet";
                    case 11:
                        return "Blue Carpet";
                    case 12:
                        return "Brown Carpet";
                    case 13:
                        return "Green Carpet";
                    case 14:
                        return "Red Carpet";
                    case 15:
                        return "Black Carpet";
                }
                return "White Carpet";
            case 172:
                return "Hardened Clay";
            case 173:
                return "Block of Coal";
            case 174:
                return "Packed Ice";
            case 175:
                switch(durability) {
                    case 0:
                        return "Sunflower";
                    case 1:
                        return "Lilac";
                    case 2:
                        return "Double Tallgrass";
                    case 3:
                        return "Large Fern";
                    case 4:
                        return "Rose Bush";
                    case 5:
                        return "Peony";
                }
                return "Sunflower";
            case 176:
                return "Free-standing Banner";
            case 177:
                return "Wall-mounted Banner";
            case 178:
                return "Inverted Daylight Sensor";
            case 179:
                switch(durability) {
                    case 0:
                        return "Red Sandstone";
                    case 1:
                        return "Chiseled Red Sandstone";
                    case 2:
                        return "Smooth Red Sandstone";
                }
                return "Red Sandstone";
            case 180:
                return "Red Sandstone Stairs";
            case 181:
                return "Double Red Sandstone Slab";
            case 182:
                return "Red Sandstone Slab";
            case 183:
                return "Spruce Fence Gate";
            case 184:
                return "Birch Fence Gate";
            case 185:
                return "Jungle Fence Gate";
            case 186:
                return "Dark Oak Fence Gate";
            case 187:
                return "Acacia Fence Gate";
            case 188:
                return "Spruce Fence";
            case 189:
                return "Birch Fence";
            case 190:
                return "Jungle Fence";
            case 191:
                return "Dark Oak Fence";
            case 192:
                return "Acacia Fence";
            case 193:
                return "Spruce Door Block";
            case 194:
                return "Birch Door Block";
            case 195:
                return "Jungle Door Block";
            case 196:
                return "Acacia Door Block";
            case 197:
                return "Dark Oak Door Block";
            case 198:
                return "End Rod";
            case 199:
                return "Chorus Plant";
            case 200:
                return "Chorus Flower";
            case 201:
                return "Purpur Block";
            case 203:
                return "Purpur Stairs";
            case 205:
                return "Purpur Slab";
            case 206:
                return "End Stone Bricks";
            case 208:
                return "Grass Path";
            case 209:
                return "End Gateway Block";
            case 212:
                return "Frosted Ice";
            case 255:
                return "Structure Block";
            case 256:
                return "Iron Shovel";
            case 257:
                return "Iron Pickaxe";
            case 258:
                return "Iron Axe";
            case 259:
                return "Flint and Steel";
            case 260:
                return "Apple";
            case 261:
                return "Bow";
            case 262:
                return "Arrow";
            case 263:
                switch(durability) {
                    case 0:
                        return "Coal";
                    case 1:
                        return "Charcoal";
                }
                return "Coal";
            case 264:
                return "Diamond";
            case 265:
                return "Iron Ingot";
            case 266:
                return "Gold Ingot";
            case 267:
                return "Iron Sword";
            case 268:
                return "Wooden Sword";
            case 269:
                return "Wooden Shovel";
            case 270:
                return "Wooden Pickaxe";
            case 271:
                return "Wooden Axe";
            case 272:
                return "Stone Sword";
            case 273:
                return "Stone Shovel";
            case 274:
                return "Stone Pickaxe";
            case 275:
                return "Stone Axe";
            case 276:
                return "Diamond Sword";
            case 277:
                return "Diamond Shovel";
            case 278:
                return "Diamond Pickaxe";
            case 279:
                return "Diamond Axe";
            case 280:
                return "Stick";
            case 281:
                return "Bowl";
            case 282:
                return "Mushroom Stew";
            case 283:
                return "Golden Sword";
            case 284:
                return "Golden Shovel";
            case 285:
                return "Golden Pickaxe";
            case 286:
                return "Golden Axe";
            case 287:
                return "String";
            case 288:
                return "Feather";
            case 289:
                return "Gunpowder";
            case 290:
                return "Wooden Hoe";
            case 291:
                return "Stone Hoe";
            case 292:
                return "Iron Hoe";
            case 293:
                return "Diamond Hoe";
            case 294:
                return "Golden Hoe";
            case 295:
                return "Wheat Seeds";
            case 296:
                return "Wheat";
            case 297:
                return "Bread";
            case 298:
                return "Leather Helmet";
            case 299:
                return "Leather Tunic";
            case 300:
                return "Leather Pants";
            case 301:
                return "Leather Boots";
            case 302:
                return "Chainmail Helmet";
            case 303:
                return "Chainmail Chestplate";
            case 304:
                return "Chainmail Leggings";
            case 305:
                return "Chainmail Boots";
            case 306:
                return "Iron Helmet";
            case 307:
                return "Iron Chestplate";
            case 308:
                return "Iron Leggings";
            case 309:
                return "Iron Boots";
            case 310:
                return "Diamond Helmet";
            case 311:
                return "Diamond Chestplate";
            case 312:
                return "Diamond Leggings";
            case 313:
                return "Diamond Boots";
            case 314:
                return "Golden Helmet";
            case 315:
                return "Golden Chestplate";
            case 316:
                return "Golden Leggings";
            case 317:
                return "Golden Boots";
            case 318:
                return "Flint";
            case 319:
                return "Raw Porkchop";
            case 320:
                return "Cooked Porkchop";
            case 321:
                return "Painting";
            case 322:
                switch(durability) {
                    case 0:
                        return "Golden Apple";
                    case 1:
                        return "Enchanted Golden Apple";
                }
                return "Golden Apple";
            case 323:
                return "Sign";
            case 324:
                return "Oak Door";
            case 325:
                return "Bucket";
            case 326:
                return "Water Bucket";
            case 327:
                return "Lava Bucket";
            case 328:
                return "Minecart";
            case 329:
                return "Saddle";
            case 330:
                return "Iron Door";
            case 331:
                return "Redstone";
            case 332:
                return "Snowball";
            case 333:
                return "Boat";
            case 334:
                return "Leather";
            case 335:
                return "Milk Bucket";
            case 336:
                return "Brick";
            case 337:
                return "Clay";
            case 338:
                return "Sugar Canes";
            case 339:
                return "Paper";
            case 340:
                return "Book";
            case 341:
                return "Slimeball";
            case 342:
                return "Minecart with Chest";
            case 343:
                return "Minecart with Furnace";
            case 344:
                return "Egg";
            case 345:
                return "Compass";
            case 346:
                return "Fishing Rod";
            case 347:
                return "Clock";
            case 348:
                return "Glowstone Dust";
            case 349:
                switch(durability) {
                    case 0:
                        return "Raw Fish";
                    case 1:
                        return "Raw Salmon";
                    case 2:
                        return "Clownfish";
                    case 3:
                        return "Pufferfish";
                }
                return "Raw Fish";
            case 350:
                switch(durability) {
                    case 0:
                        return "Cooked Fish";
                    case 1:
                        return "Cooked Salmon";
                }
                return "Cooked Fish";
            case 351:
                switch(durability) {
                    case 0:
                        return "Ink Sack";
                    case 1:
                        return "Rose Red";
                    case 2:
                        return "Cactus Green";
                    case 3:
                        return "Coco Beans";
                    case 4:
                        return "Lapis Lazuli";
                    case 5:
                        return "Purple Dye";
                    case 6:
                        return "Cyan Dye";
                    case 7:
                        return "Light Gray Dye";
                    case 8:
                        return "Gray Dye";
                    case 9:
                        return "Pink Dye";
                    case 10:
                        return "Lime Dye";
                    case 11:
                        return "Dandelion Yellow";
                    case 12:
                        return "Light Blue Dye";
                    case 13:
                        return "Magenta Dye";
                    case 14:
                        return "Orange Dye";
                    case 15:
                        return "Bone Meal";
                }
                return "Ink Sack";
            case 352:
                return "Bone";
            case 353:
                return "Sugar";
            case 354:
                return "Cake";
            case 355:
                return "Bed";
            case 356:
                return "Redstone Repeater";
            case 357:
                return "Cookie";
            case 358:
                return "Map";
            case 359:
                return "Shears";
            case 360:
                return "Melon";
            case 361:
                return "Pumpkin Seeds";
            case 362:
                return "Melon Seeds";
            case 363:
                return "Raw Beef";
            case 364:
                return "Steak";
            case 365:
                return "Raw Chicken";
            case 366:
                return "Cooked Chicken";
            case 367:
                return "Rotten Flesh";
            case 368:
                return "Ender Pearl";
            case 369:
                return "Blaze Rod";
            case 370:
                return "Ghast Tear";
            case 371:
                return "Gold Nugget";
            case 372:
                return "Nether Wart";
            case 373:
                return "Potion";
            case 374:
                return "Glass Bottle";
            case 375:
                return "Spider Eye";
            case 376:
                return "Fermented Spider Eye";
            case 377:
                return "Blaze Powder";
            case 378:
                return "Magma Cream";
            case 379:
                return "Brewing Stand";
            case 380:
                return "Cauldron";
            case 381:
                return "Eye of Ender";
            case 382:
                return "Glistering Melon";
            case 383:
                switch(durability) {
                    case 65:
                        return "Spawn Bat";
                    case 66:
                        return "Spawn Witch";
                    case 67:
                        return "Spawn Endermite";
                    case 68:
                        return "Spawn Guardian";
                    case 90:
                        return "Spawn Pig";
                    case 91:
                        return "Spawn Sheep";
                    case 92:
                        return "Spawn Cow";
                    case 93:
                        return "Spawn Chicken";
                    case 94:
                        return "Spawn Squid";
                    case 95:
                        return "Spawn Wolf";
                    case 96:
                        return "Spawn Mooshroom";
                    case 98:
                        return "Spawn Ocelot";
                    case 100:
                        return "Spawn Horse";
                    case 101:
                        return "Spawn Rabbit";
                    case 50:
                        return "Spawn Creeper";
                    case 51:
                        return "Spawn Skeleton";
                    case 52:
                        return "Spawn Spider";
                    case 54:
                        return "Spawn Zombie";
                    case 55:
                        return "Spawn Slime";
                    case 56:
                        return "Spawn Ghast";
                    case 120:
                        return "Spawn Villager";
                    case 57:
                        return "Spawn Pigman";
                    case 58:
                        return "Spawn Enderman";
                    case 59:
                        return "Spawn Cave Spider";
                    case 60:
                        return "Spawn Silverfish";
                    case 61:
                        return "Spawn Blaze";
                    case 62:
                        return "Spawn Magma Cube";
                    // TODO Shulker
                }
                return "null";
            case 384:
                return "Bottle o' Enchanting";
            case 385:
                return "Fire Charge";
            case 386:
                return "Book and Quill";
            case 387:
                return "Written Book";
            case 388:
                return "Emerald";
            case 389:
                return "Item Frame";
            case 390:
                return "Flower Pot";
            case 391:
                return "Carrot";
            case 392:
                return "Potato";
            case 393:
                return "Baked Potato";
            case 394:
                return "Poisonous Potato";
            case 395:
                return "Empty Map";
            case 396:
                return "Golden Carrot";
            case 397:
                switch(durability) {
                    case 0:
                        return "Mob Head (Skeleton)";
                    case 1:
                        return "Mob Head (Wither Skeleton)";
                    case 2:
                        return "Mob Head (Zombie)";
                    case 3:
                        return "Mob Head (Human)";
                    case 4:
                        return "Mob Head (Creeper)";
                    // TODO: Dragon Head
                }
                return "Mob Head (Skeleton)";
            case 398:
                return "Carrot on a Stick";
            case 399:
                return "Nether Star";
            case 400:
                return "Pumpkin Pie";
            case 401:
                return "Firework Rocket";
            case 402:
                return "Firework Star";
            case 403:
                return "Enchanted Book";
            case 404:
                return "Redstone Comparator";
            case 405:
                return "Nether Brick";
            case 406:
                return "Nether Quartz";
            case 407:
                return "Minecart with TNT";
            case 408:
                return "Minecart with Hopper";
            case 409:
                return "Prismarine Shard";
            case 410:
                return "Prismarine Crystals";
            case 411:
                return "Raw Rabbit";
            case 412:
                return "Cooked Rabbit";
            case 413:
                return "Rabbit Stew";
            case 414:
                return "Rabbit's Foot";
            case 415:
                return "Rabbit Hide";
            case 416:
                return "Armor Stand";
            case 417:
                return "Iron Horse Armor";
            case 418:
                return "Golden Horse Armor";
            case 419:
                return "Diamond Horse Armor";
            case 420:
                return "Lead";
            case 421:
                return "Name Tag";
            case 422:
                return "Minecart with Command Block";
            case 423:
                return "Raw Mutton";
            case 424:
                return "Cooked Mutton";
            case 425:
                return "Banner";
            case 426:
                return "End Crystal";
            case 427:
                return "Spruce Door";
            case 428:
                return "Birch Door";
            case 429:
                return "Jungle Door";
            case 430:
                return "Acacia Door";
            case 431:
                return "Dark Oak Door";
            case 432:
                return "Chorus Fruit";
            case 433:
                return "Popped Chorus Fruit";
            case 434:
                return "Beetroot";
            case 435:
                return "Beetroot Seeds";
            case 436:
                return "Beetroot Soup";
            case 437:
                return "Dragon's Breath";
            case 439:
                return "Spectral Arrow";
            case 440:
                return "Tipped Arrow";
            case 441:
                return "Lingering Potion";
            case 442:
                return "Shield";
            case 443:
                return "Elytra";
            case 2256:
                return "13 Disc";
            case 2257:
                return "Cat Disc";
            case 2258:
                return "Blocks Disc";
            case 2259:
                return "Chirp Disc";
            case 2260:
                return "Far Disc";
            case 2261:
                return "Mall Disc";
            case 2262:
                return "Mellohi Disc";
            case 2263:
                return "Stal Disc";
            case 2264:
                return "Strad Disc";
            case 2265:
                return "Ward Disc";
            case 2266:
                return "11 Disc";
            case 2267:
                return "Wait Disc";
        }
        return "Item";
    }
}
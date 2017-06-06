package Game;
import java.util.Scanner;

class Skills{
    public void skills(){
        System.out.println("Basic,Heal,Item,Run");
    }
}

public class Client {

    private static String command, commandAttack, commandShop;
    private static int monsterRat = 100;
    private static int monsterWeasel = 110;
    private static int monsterBear = 120;
    private static int hp = 100;
    private static int level = 0;
    private static int mana = 10;
    private static int expTotal = 0;
    private static int goldTotal = 0;
    private static int commandItem, commandBuy, arrow,
            shuriken, bomb, hpPotion, mpPotion, potion, items;
    public Skills skillObject = new Skills();

    public static void title(){
        System.out.println("Welcome To My First Game!");
    }
    //BEGINNING OF MONSTERS
    //First Monster - Easy
    public static void huntRat(){
        Scanner console = new Scanner(System.in);
        System.out.println("A Monster Appeared! Its a Wild Rat! ");
        do
        {
            System.out.print("What Skill do you want to use?"
                    + "\nBasic,Heal,Item,Run: ");
            commandAttack = console.next();
            System.out.println("");
            if(commandAttack.equalsIgnoreCase("Run")){
                game();
            }
            if(commandAttack.equalsIgnoreCase("Basic")){
                int attack = (int)(15 + Math.random()*40-15+1);
                System.out.println("-You have done: "
                        + attack + " damage");
                monsterRat = monsterRat - attack;
                System.out.println("-The Wild Rat has: "
                        + monsterRat + " HP left!\n");
            }
            if(commandAttack.equalsIgnoreCase("Heal") && mana >= 2){
                int healing = (int)(10 + Math.random()*35-10+1);
                hp = Math.min(hp + healing, 100);
                mana = Math.max(mana - 2, 0);
                System.out.println("-You have healed: " + healing
                        + "\n-You have now: " + hp + " hp!\n"
                        + "Mana: " + mana + "/10\n");
            }
            if(commandAttack.equalsIgnoreCase("Item") && items >= 1){
                System.out.println("Choose what to use::\n");
                System.out.println("1. Arrow: " + arrow + "\n"
                        + "2. Shurkiken: " + shuriken + "\n"
                        + "3. Bombs: " + bomb + "\n"
                        + "4. Small HP-Potion: " + hpPotion + "\n"
                        + "5. Mana-Potion: " + mpPotion + "\n"
                        + "6. Large HP-Potion: " + potion + "\n");
                commandItem = console.nextInt();
                if(commandItem == 1 && arrow >= 1){
                    System.out.println("You fire an arrow at the monster!");
                    int attack = 20;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterRat = monsterRat - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterRat + " HP left!\n");
                    arrow--;
                }
                if(commandItem == 2 && shuriken >= 1){
                    System.out.println("You throw a shuriken at the monster!");
                    int attack = 40;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterRat = monsterRat - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterRat + " HP left!\n");
                    shuriken--;
                }
                if(commandItem == 3 && bomb >= 1){
                    System.out.println("-You throw a bomb at the monster!");
                    int attack = 60;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterRat = monsterRat - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterRat + " HP left!\n");
                    bomb--;
                }
                if(commandItem == 4 && hpPotion >= 1){
                    int healing = 20;
                    hp = hp + healing;
                    System.out.println("-You have healed: " + healing
                            + "\n-You have now: " + hp + " hp!\n");
                    hpPotion--;
                }
                if(commandItem == 5 && mpPotion >= 1){
                    mana = 10;
                    System.out.println("-You now have 10/10 mana!");
                    mpPotion--;
                }
                if(commandItem == 6 && potion >= 1){
                    int healing = 40;
                    hp = hp + healing;
                    System.out.println("-You have healed: " + healing
                            + "\n-You have now: " + hp + " hp!\n");
                    potion--;
                }
            }
            if(monsterRat > 0){
                int dmg = (int)(10 + Math.random()*25-10+1);
                hp = hp - dmg;
                System.out.println("-The Wild Rat has done: " + dmg
                        + " HP of damage to you!\n" + "-You have: "
                        + hp + "hp left!\n");
            }
            if(hp <= 0){ //Die = GameOver
                System.out.println("-You have died! Game Over!");
                System.exit(0);
            }
            mana = Math.min(mana + 1, 10);
        }
        while(monsterRat >= 1);
        //after battle if wins
        int expRat = (int)(5 + Math.random()*50-5+1);
        int goldRat = (int)(5 + Math.random()*10-5+1);
        goldTotal = goldTotal + goldRat;
        expTotal = expTotal + expRat;
        System.out.println("You have gotten: " + expRat
                + " EXP!\nYou picked up: "
                + goldRat + " gold!\n");
        monsterRat = 100;
    }
    //Second Monster - Intermediate
    public static void huntWeasel(){
        Scanner console = new Scanner(System.in);
        System.out.println("A Monster Appeared! Its a Wild Weasel! ");
        do
        {
            System.out.print("What Skill do you want to use?"
                    + "\nBasic,Heal,Item,Run: ");
            commandAttack = console.next();
            System.out.println("");
            if(commandAttack.equalsIgnoreCase("Run")){
                game();
            }
            if(commandAttack.equalsIgnoreCase("Basic")){
                int attack = (int)(15 + Math.random()*40-15+1);
                System.out.println("-You have done: "
                        + attack + " damage");
                monsterWeasel = monsterWeasel - attack;
                System.out.println("-The Wild Weasel has: "
                        + monsterWeasel + " HP left!\n");
            }
            if(commandAttack.equalsIgnoreCase("Heal") && mana >= 2){
                int healing = (int)(10 + Math.random()*35-10+1);
                hp = Math.min(hp + healing, 100);
                mana = Math.max(mana - 2, 0);
                System.out.println("-You have healed: " + healing
                        + "\n-You have now: " + hp + " hp!\n"
                        + "Mana: " + mana + "/10\n");
            }
            if(commandAttack.equalsIgnoreCase("Item") && items >= 1){
                System.out.println("Choose what to use::\n");
                System.out.println("1. Arrow: " + arrow + "\n"
                        + "2. Shurkiken: " + shuriken + "\n"
                        + "3. Bombs: " + bomb + "\n"
                        + "4. Small HP-Potion: " + hpPotion + "\n"
                        + "5. Mana-Potion: " + mpPotion + "\n"
                        + "6. Large HP-Potion: " + potion + "\n");
                commandItem = console.nextInt();
                if(commandItem == 1 && arrow >= 1){
                    System.out.println("You fire an arrow at the monster!");
                    int attack = 20;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterWeasel = monsterWeasel - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterWeasel + " HP left!\n");
                    arrow--;
                }
                if(commandItem == 2 && shuriken >= 1){
                    System.out.println("You throw a shuriken at the monster!");
                    int attack = 40;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterWeasel = monsterWeasel - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterWeasel + " HP left!\n");
                    shuriken--;
                }
                if(commandItem == 3 && bomb >= 1){
                    System.out.println("You throw a bomb at the monster!");
                    int attack = 60;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterWeasel = monsterWeasel - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterWeasel + " HP left!\n");
                    bomb--;
                }
                if(commandItem == 4 && hpPotion >= 1){
                    int healing = 20;
                    hp = hp + healing;
                    System.out.println("-You have healed: " + healing
                            + "\n-You have now: " + hp + " hp!\n");
                    hpPotion--;
                }
                if(commandItem == 5 && mpPotion >= 1){
                    mana = 10;
                    System.out.println("-You now have 10/10 mana!");
                    mpPotion--;
                }
                if(commandItem == 6 && potion >= 1){
                    int healing = 40;
                    hp = hp + healing;
                    System.out.println("-You have healed: " + healing
                            + "\n-You have now: " + hp + " hp!\n");
                    potion--;
                }
            }
            if(monsterWeasel > 0){
                int dmg = (int)(10 + Math.random()*30-10+1);
                hp = hp - dmg;
                System.out.println("-The Wild Weasel has done: " + dmg
                        + " HP of damage to you!\n" + "-You have: " + hp + "hp left!\n");
            }
            if(hp <= 0){ //Die = GameOver
                System.out.println("-You have died! Game Over!");
                System.exit(0);
            }
            mana = Math.min(mana + 1, 10);
        }
        while(monsterWeasel >= 1);
        //after battle if wins
        int expWeasel = (int)(20 + Math.random()*75-20+1);
        int goldWeasel = (int)(10 + Math.random()*30-10+1);
        goldTotal = goldTotal + goldWeasel;
        expTotal = expTotal + expWeasel;
        System.out.println("You have gotten: " + expWeasel
                + " EXP!\nYou picked up: "
                + goldWeasel + " gold!\n");
        monsterWeasel = 110;
    }
    //Third Monster - Hardest
    public static void huntBear(){
        Scanner console = new Scanner(System.in);
        System.out.println("A Monster Appeared! Its a Wild Bear! ");
        do
        {
            System.out.print("What Skill do you want to use?"
                    + "\nBasic,Heal,Item,Run: ");
            commandAttack = console.next();
            System.out.println("");
            if(commandAttack.equalsIgnoreCase("Run")){
                game();
            }
            if(commandAttack.equalsIgnoreCase("Basic")){
                int attack = (int)(15 + Math.random()*40-15+1);
                System.out.println("-You have done: "
                        + attack + " damage");
                monsterBear = monsterBear - attack;
                System.out.println("-The Wild Bear has: "
                        + monsterBear + " HP left!\n");
            }
            if(commandAttack.equalsIgnoreCase("Heal") && mana >= 2){
                int healing = (int)(10 + Math.random()*35-10+1);
                hp = Math.min(hp + healing, 100);
                mana = Math.max(mana - 2, 0);
                System.out.println("-You have healed: " + healing
                        + "\n-You have now: " + hp + " hp!\n"
                        + "Mana: " + mana + "/10\n");
            }
            if(commandAttack.equalsIgnoreCase("Item") && items >= 1){
                System.out.println("Choose what to use::\n");
                System.out.println("1. Arrow: " + arrow + "\n"
                        + "2. Shurkiken: " + shuriken + "\n"
                        + "3. Bombs: " + bomb + "\n"
                        + "4. Small HP-Potion: " + hpPotion + "\n"
                        + "5. Mana-Potion: " + mpPotion + "\n"
                        + "6. Large HP-Potion: " + potion + "\n");
                commandItem = console.nextInt();
                if(commandItem == 1 && arrow >= 1){
                    System.out.println("You fire an arrow at the monster!");
                    int attack = 20;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterBear = monsterBear - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterBear + " HP left!\n");
                    arrow--;
                }
                if(commandItem == 2 && shuriken >= 1){
                    System.out.println("You throw a shuriken at the monster!");
                    int attack = 40;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterBear = monsterBear - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterBear + " HP left!\n");
                    shuriken--;
                }
                if(commandItem == 3 && bomb >= 1){
                    System.out.println("You throw a bomb at the monster!");
                    int attack = 60;
                    System.out.println("-You have done: "
                            + attack + " damage");
                    monsterBear = monsterBear - attack;
                    System.out.println("-The Wild Rat has: "
                            + monsterBear + " HP left!\n");
                    bomb--;
                }
                if(commandItem == 4 && hpPotion >= 1){
                    int healing = 20;
                    hp = hp + healing;
                    System.out.println("-You have healed: " + healing
                            + "\n-You have now: " + hp + " hp!\n");
                    hpPotion--;
                }
                if(commandItem == 5 && mpPotion >= 1){
                    mana = 10;
                    System.out.println("-You now have 10/10 mana!");
                    mpPotion--;
                }
                if(commandItem == 6 && potion >= 1){
                    int healing = 40;
                    hp = hp + healing;
                    System.out.println("-You have healed: " + healing
                            + "\n-You have now: " + hp + " hp!\n");
                    potion--;
                }
            }
            if(monsterBear > 0){
                int dmg = (int)(14 + Math.random()*35-14+1);
                hp = hp - dmg;
                System.out.println("-The Wild Bear has done: " + dmg
                        + " HP of damage to you!\n"
                        + "-You have: " + hp + "hp left!\n");
            }
            if(hp <= 0){ //Die = GameOver
                System.out.println("-You have died! Game Over!");
                System.exit(0);
            }
            mana = Math.min(mana + 1, 10);
        }
        while(monsterBear >= 1);
        //after battle if wins
        int expBear = (int)(40 + Math.random()*120-40+1);
        int goldBear = (int)(30 + Math.random()*50-30+1);
        goldTotal = goldTotal + goldBear;
        expTotal = expTotal + expBear;
        System.out.println("You have gotten: " + expBear
                + " EXP!\nYou picked up: "
                + goldBear + " gold!\n");
        monsterBear = 120;
    }
    //END OF MONSTERS

    public static void shop(){
        do
        {
            Scanner console = new Scanner(System.in);
            System.out.print("----------------------------\nWhat do you want to"
                    + " shop for? | Weapons | Items | Magic | Leave |\n"
                    + "Choice: ");
            commandShop = console.next();
            System.out.println();
            if(commandShop.equalsIgnoreCase("Weapons")){
                System.out.print("What do you want to buy?\n1. Arrow - 10g"
                        + " DMG: 20 (lvl: 0)\n2. Shuriken - 20g DMG: 40 (lvl: 1)"
                        + "\n3. Bomb - 40g DMG: 60 (lvl: 2)\n"
                        + "Choice: ");
                commandBuy = console.nextInt();
                System.out.println();
                if(commandBuy == 1 && goldTotal >= 10){
                    arrow++;
                    items++;
                    goldTotal = goldTotal - 10;
                    System.out.println("You now have: " + arrow + " Arrow(s)!\n"
                            + "You now have: " + goldTotal + " gold!\n");
                }
                if(commandBuy == 2 && goldTotal >= 20 && level >= 1){
                    shuriken++;
                    items++;
                    goldTotal = goldTotal - 20;
                    System.out.println("You now have: " + shuriken
                            + " Shuriken(s)!\n"
                            + "You now have: " + goldTotal + " gold!\n");
                }
                if(commandBuy == 3 && goldTotal >= 40 && level >= 2){
                    bomb++;
                    items++;
                    goldTotal = goldTotal - 40;
                    System.out.println("You now have: " + bomb + " Bomb(s)!\n"
                            + "You now have: " + goldTotal + " gold!\n");
                }
                else{
                    System.out.println("You do not have the required level or gold"
                            + "need to buy this weapon!");
                }
            }
            if(commandShop.equalsIgnoreCase("Items")){
                System.out.print("What do you want to buy?\n"
                        + "1. Small HP-Potion - 10g Heal: 20 (lvl: 0)\n"
                        + "2. Mana-Potion - 20g Full-Mana (lvl: 1)\n"
                        + "3. Large HP-Potion - 40g Heal: 40 (lvl: 2)\n"
                        + "Choice: ");
                commandShop = console.next();
                System.out.println();
                if(commandBuy == 1 && goldTotal >= 10){
                    hpPotion++;
                    items++;
                    goldTotal = goldTotal - 10;
                    System.out.println("You now have: "
                            + hpPotion + " Small HP-Potion(s)!\n"
                            + "You now have: " + goldTotal + " gold!\n");
                }
                if(commandBuy == 2 && goldTotal >= 20 && level >= 1){
                    mpPotion++;
                    items++;
                    goldTotal = goldTotal - 20;
                    System.out.println("You now have: "
                            + mpPotion + " Mana-Potion(s)!\n"
                            + "You now have: " + goldTotal + " gold!\n");
                }
                if(commandBuy == 3 && goldTotal >= 40 && level >= 2){
                    potion++;
                    items++;
                    goldTotal = goldTotal - 40;
                    System.out.println("You now have: "
                            + potion + " Large HP-Potions(s)!\n"
                            + "You now have: " + goldTotal + " gold!\n");
                }
                else{
                    System.out.println("You do not have the required level or gold"
                            + "need to buy this item!");
                }
            }
            if(commandShop.equalsIgnoreCase("Magic")){
                System.out.println("Not implemented yet!\n");
            }
        }
        while(!commandShop.equalsIgnoreCase("Leave"));
    }

    public static void game(){   // last static void used - User input For Home
        Scanner console = new Scanner(System.in);
        do
        {
            System.out.print("-----------------------\n"
                    + "What do you want to do?\n"
                    + "Hunt | Shop | Sleep | Skills |\nStats | LevelUp"
                    + " | Inventory |\n"
                    + "Choice: ");
            command=console.next();
            System.out.println();
            if(command.equalsIgnoreCase("Hunt")){
                int monsterChance = (int)(1 + Math.random()*100-1+1);
                if(monsterChance <= 50){
                    huntRat();
                }
                if(monsterChance <=90 && monsterChance > 50){
                    huntWeasel();
                }
                if(monsterChance <=100 && monsterChance > 90){
                    huntBear();
                }
            }
            if(command.equalsIgnoreCase("Sleep")){
                hp = 100;
                mana = 10;
                System.out.println("You HP is now at 100"
                        + " and your Mana is at 10!");
            }
            if(command.equalsIgnoreCase("Stats")){
                System.out.println("You have: " + expTotal
                        + " exp!\nYou have: " + goldTotal + " gold!\n"
                        + "Your level is: " + level);
            }
            if(command.equalsIgnoreCase("LevelUp")){
                if(expTotal >= 100){
                    level++;
                    System.out.println("CONGRATS! You have leveled up!"
                            + "\nYour level is: " + level);
                    expTotal = expTotal - 100;
                }
                else{
                    System.out.println("You don't have enough exp! Hunt more!");
                }
            }
            if(command.equalsIgnoreCase("Shop")){
                System.out.println("Welcome to the shops!");
                shop();
            }
            if(command.equalsIgnoreCase("Inventory")){
                System.out.println("You have: " + arrow + " arrow(s)\n"
                        + "You have: " + shuriken + " shuriken(s)\n"
                        + "You have: " + bomb + " bomb(s)\n"
                        + "You have: " + hpPotion + " Small Hp-Potion(s)\n"
                        + "You have: " + mpPotion + " Mana-Potion(s)\n"
                        + "You have: " + potion + " Large Hp-Potion(s)\n");
            }
            if(command.equalsIgnoreCase("Skills")){
                Skills skillObject = new Skills();
                skillObject.skills();
            }
        }
        while(!command.equalsIgnoreCase("STOP"));         //how to stop Game
        System.out.println("You have left the Game without saving!");
    }
    public static void main(String[] args) {
        title();
        game();
    }
}
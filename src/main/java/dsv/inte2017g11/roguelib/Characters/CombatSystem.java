package dsv.inte2017g11.roguelib.Characters;

public interface CombatSystem {

    public static void heal(int healItem, AbstractCharacter thisChar) {
        int tempHealth = thisChar.getCurrentHealth();
        if(tempHealth!=0) {
            tempHealth += healItem;
            if (tempHealth > thisChar.getMaxHealth()) {
                tempHealth = thisChar.getMaxHealth();
            }
        }
        thisChar.setCurrentHealth(tempHealth);
    }


    public static void takeElementalDamage(int enemyAttackValue, String enemyElement, AbstractCharacter thisChar) {
        int tempHealth = thisChar.getCurrentHealth();

        if(thisChar instanceof Pet){
            tempHealth -= enemyAttackValue * calculateElementDamage(enemyElement, ((Pet)thisChar).getElement());
        } else{
            tempHealth -= enemyAttackValue;
        }

        if (tempHealth<0){
            tempHealth = 0;
        }
        thisChar.setCurrentHealth(tempHealth);
    }


    public static double calculateElementDamage(String enemyElement, String thisElement) {
        double damagePercent = 1;
        if (enemyElement.compareTo(thisElement) == 0) {
            return 1;
        } else if (enemyElement == "Fire") {
            if (thisElement == "Earth") {
                damagePercent = 0.75;
            } else if (thisElement == "Wind") {
                damagePercent = 1.25;
            }
        } else if (enemyElement == "Earth") {
            if (thisElement == "Fire") {
                damagePercent = 1.25;
            } else if (thisElement == "Wind") {
                damagePercent = 0.75;
            }
        } else if (enemyElement =="Wind"){
            if(thisElement=="Earth"){
                damagePercent = 1.25;
            } else {
                damagePercent = 0.75;
            }
        }
        return damagePercent;
    }

    public static void revive(AbstractCharacter thisChar) {
        if(thisChar.getCurrentHealth()==0){
            thisChar.setCurrentHealth(10);
        }
    }

    public static void phoenixDown(AbstractCharacter thisChar) {
            thisChar.setCurrentHealth(thisChar.getMaxHealth());
    }

}

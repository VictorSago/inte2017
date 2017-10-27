package dsv.inte2017g11.roguelib.Characters;

public interface CombatSystem {

    static void heal(int healItem, AbstractCharacter thisChar) {
        int tempHealth = thisChar.getCurrentHealth();
        if(tempHealth!=0) {
            tempHealth += healItem;
            if (tempHealth > thisChar.getMaxHealth()) {
                tempHealth = thisChar.getMaxHealth();
            }
        }
        thisChar.setCurrentHealth(tempHealth);
    }


    static void takeDamage(int enemyAttackValue, String enemyElement, AbstractCharacter thisChar) {
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


    static double calculateElementDamage(String enemyElement, String thisElement) {
        double damagePercent = 1;
        if (enemyElement.compareTo(thisElement) == 0) {
            return 1;
        } else if (enemyElement.equalsIgnoreCase("Fire")) {
            if (thisElement.equalsIgnoreCase("Earth")) {
                damagePercent = 0.75;
            } else if (thisElement.equalsIgnoreCase("Wind")) {
                damagePercent = 1.25;
            }
        } else if (enemyElement.equalsIgnoreCase("Earth")) {
            if (thisElement.equalsIgnoreCase("Fire")) {
                damagePercent = 1.25;
            } else if (thisElement.equalsIgnoreCase("Wind")) {
                damagePercent = 0.75;
            }
        } else if (enemyElement.equalsIgnoreCase("Wind")){
            if(thisElement.equalsIgnoreCase("Earth")){
                damagePercent = 1.25;
            } else {
                damagePercent = 0.75;
            }
        }
        return damagePercent;
    }

    static void revive(AbstractCharacter thisChar) {
        if(thisChar.getCurrentHealth()==0){
            thisChar.setCurrentHealth(10);
        }
    }

    static void phoenixDown(AbstractCharacter thisChar) {
            thisChar.setCurrentHealth(thisChar.getMaxHealth());
    }

}

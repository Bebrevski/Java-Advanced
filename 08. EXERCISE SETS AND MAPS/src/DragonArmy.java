import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DragonArmy {

    public static class DragonStats {
        private Integer Damage;
        private Integer Health;
        private Integer Armor;

        DragonStats(Integer damage, Integer health, Integer armor) {
            this.setDamage(damage);
            this.setHealth(health);
            this.setArmor(armor);
        }

        Integer getDamage() {
            return this.Damage;
        }

        void setDamage(Integer newValue) {
            this.Damage = newValue;
        }

        Integer getHealth() {
            return this.Health;
        }

        void setHealth(Integer newValue) {
            this.Health = newValue;
        }

        Integer getArmor() {
            return this.Armor;
        }

        void setArmor(Integer newValue) {
            this.Armor = newValue;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, DragonStats>> record = new LinkedHashMap<>();

        Integer n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String type = tokens[0];
            String name = tokens[1];

            Integer damage = !tokens[2].equals("null") ? Integer.parseInt(tokens[2]) : 45;
            Integer health = !tokens[3].equals("null") ? Integer.parseInt(tokens[3]) : 250;
            Integer armor = !tokens[4].equals("null") ? Integer.parseInt(tokens[4]) : 10;

            record.putIfAbsent(type, new LinkedHashMap<>());
            DragonStats currentDragon = new DragonStats(damage, health, armor);
            record.get(type).putIfAbsent(name, currentDragon);
        }

        Double averageDamage = 0D;
        Double averageHealth = 0D;
        Double averageArmor = 0D;
        for (Map.Entry<String, Map<String, DragonStats>> dragon : record.entrySet()) {
            for (Map.Entry<String, DragonStats> kvp : dragon.getValue().entrySet()) {
                averageDamage += kvp.getValue().getDamage();
                averageHealth += kvp.getValue().getHealth();
                averageArmor += kvp.getValue().getArmor();
            }

            Integer count = dragon.getValue().size();
            averageDamage /= count;
            averageHealth /= count;
            averageArmor /= count;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n"
                    , dragon.getKey()
                    , averageDamage
                    , averageHealth
                    , averageArmor);

            dragon.getValue().entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .forEach(d -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                    ,d.getKey()
                    ,d.getValue().getDamage()
                    ,d.getValue().getHealth()
                    ,d.getValue().getArmor()));

            averageDamage = 0D;
            averageHealth = 0D;
            averageArmor = 0D;
        }
    }
}

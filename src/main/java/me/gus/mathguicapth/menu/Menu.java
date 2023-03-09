package me.gus.mathguicapth.menu;

import me.gus.mathguicapth.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Random;

public class Menu {
    public static final Menu instance = new Menu();
    public Random numberGenerator = new Random();

    private int firstNumber;
    private int secondNumber;
    private int numbersSum;
    private int botAnswer;
    private int botSecondAnswer;
    private int setRandomSlot;
    private int setSecondRandomSlot;

    public int getNumbersSum() {
        return this.numbersSum;
    }
    public int firstNumber() {
        return this.firstNumber;
    }
    public int secondNumber() {
        return this.secondNumber;
    }

    public int getNumbersSumPlus() {
        return this.numbersSum;
    }
    public int firstNumberPlus() {
        return this.firstNumber;
    }
    public int secondNumberPlus() {
        return this.secondNumber;
    }

    public void generateRandomNumbers() {
        this.firstNumber = numberGenerator.nextInt(4) + 1;
        this.secondNumber = numberGenerator.nextInt(4) + 1;

        while (this.firstNumber == this.secondNumber) {
            this.secondNumber = numberGenerator.nextInt(4) + 1;
        }

        this.numbersSum = firstNumber + secondNumber;

        this.botAnswer = numberGenerator.nextInt(15) + 6;
        this.botSecondAnswer = numberGenerator.nextInt(11) + 2;

        this.setRandomSlot = (int) ((Math.random() * (52 - 1)) + 1);
        this.setSecondRandomSlot = (int) ((Math.random() * (51 - 1)) + 1);
    }

    public Inventory getInventory(Player player) {
        generateRandomNumbers();
        final Inventory inventory = Bukkit.createInventory(null, 54, "Вычисли: " + firstNumber + " + " + secondNumber + " = ???");
        inventory.setItem(setRandomSlot, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(numbersSum)));
        inventory.setItem(setRandomSlot + 2, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer)));
        inventory.setItem(setSecondRandomSlot + 3, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botSecondAnswer)));
        player.openInventory(inventory);
        return inventory;
    }

    public void openInventoryPlus(Player player) {
        generateRandomNumbers();
        final Inventory inventory = Bukkit.createInventory(null, 54, "Вычислите: " + firstNumber + " + " + secondNumber + " = ???");
        inventory.setItem(setRandomSlot, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(numbersSum)));
        inventory.setItem(setRandomSlot + 2, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer)));
        inventory.setItem(setSecondRandomSlot + 3, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botSecondAnswer)));
        player.openInventory(inventory);
    }

    public Inventory getInventoryPlus(Player player) {
        generateRandomNumbers();
        final Inventory inventory = Bukkit.createInventory(null, 54, "Вычислите: " + firstNumber + " + " + secondNumber + " = ???");
        inventory.setItem(setRandomSlot, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(numbersSum)));
        inventory.setItem(setRandomSlot + 2, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botAnswer)));
        inventory.setItem(setSecondRandomSlot + 3, Util.createItemStack(Material.CAKE, "§c(!) §7Мой ответ: " + String.valueOf(botSecondAnswer)));
        player.openInventory(inventory);
        return inventory;
    }
}
package me.gus.mathguicapth.events;

import me.gus.mathguicapth.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerKickEvent;;

public class Event implements Listener {

    public int userAttempts = 0;
    public boolean closeUserMenuList = false;
    public boolean closeUserMenuListTwo = false;


    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        String name = player.getName();

        if (e.getView().getTitle().equals("Вычисли: " + Menu.instance.firstNumber() + " + " + Menu.instance.secondNumber() + " = ???")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                String itemName = e.getCurrentItem().getItemMeta().getDisplayName();

                int numbersSum = Menu.instance.getNumbersSum();

                if (itemName.equals("§c(!) §7Мой ответ: " + numbersSum)) {

                    closeUserMenuList = true;
                    player.closeInventory();
                    player.sendMessage("§c(!) §7Ура");

                } else {

                    closeUserMenuList = true;
                    player.openInventory(Menu.instance.getInventoryPlus(player));
                    player.sendMessage("§c(!) §7Не ура");

                }
            } else if (e.getCurrentItem() == null) {

                userAttempts = 0;
                player.kickPlayer("Вы нажали в пустой слот меню!");

            }
        }
    }

    @EventHandler
    public void onClickPlus(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        String name = e.getWhoClicked().getName();

        if (e.getView().getTitle().equals("Вычислите: " + Menu.instance.firstNumberPlus() + " + " + Menu.instance.secondNumberPlus() + " = ???")) { // костыли

            e.setCancelled(true);

            if (e.getCurrentItem() != null) {

                String itemName = e.getCurrentItem().getItemMeta().getDisplayName();

                int numbersSum = Menu.instance.getNumbersSum();

                if (itemName.equals("§c(!) §7Мой ответ: " + numbersSum)) {

                    closeUserMenuListTwo = true;
                    player.closeInventory();
                    player.sendMessage("§c(!) §7Ура");

                } else {

                    closeUserMenuListTwo = true;
                    player.openInventory(Menu.instance.getInventoryPlus(player));
                    player.sendMessage("§c(!) §7Не ура");
                    closeUserMenuListTwo = false;

                }

            } else if (e.getCurrentItem() == null) {

                userAttempts = 0;
                player.kickPlayer("Вы нажали в пустой слот меню!");

            }
        }
    }

    @EventHandler
    public void menuNumeration(InventoryOpenEvent e) {

        if (e.getView().getTitle().equals("Вычислите: " + Menu.instance.firstNumberPlus() + " + " + Menu.instance.secondNumberPlus() + " = ???")) {

            String name = e.getPlayer().getName();
            Player player = (Player) e.getPlayer();

            userAttempts++;

            if (userAttempts >= 5) {

                userAttempts = 0;
                player.kickPlayer("Ивенты Dev!");

            }

        }
    }

    @EventHandler
    public void closeUserMenu(InventoryCloseEvent e) {

        String name = e.getPlayer().getName();
        Player player = (Player) e.getPlayer();

        if (e.getView().getTitle().equals("Вычисли: " + Menu.instance.firstNumber() + " + " + Menu.instance.secondNumber() + " = ???")) {

            if (closeUserMenuList == false) {

                userAttempts = 0;
                player.kickPlayer("Нельзя закрывать капчу, до её решения!");

            } else if (closeUserMenuList == true) {

                player.sendMessage("Удачной игры на проекте!");

            }

        }
    }

    @EventHandler
    public void Disconect(PlayerKickEvent e) {

        userAttempts = 0;
        closeUserMenuList = false;
        closeUserMenuListTwo = false;

    }

}

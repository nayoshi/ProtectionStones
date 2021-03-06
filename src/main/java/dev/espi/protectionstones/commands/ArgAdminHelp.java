/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.espi.protectionstones.commands;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ArgAdminHelp {

    private static void send(CommandSender p, String text, String info) {
        TextComponent tc = new TextComponent(text);
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(info).create()));
        p.spigot().sendMessage(tc);
    }

    static boolean argumentAdminHelp(CommandSender p, String[] args) {
        p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "=====" + ChatColor.RESET + " PS Admin Help " + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "=====\n" + ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin help");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin version", "Show the version number of the plugin.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin hide", "Hide all of the protection stone blocks in the world you are in.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin unhide", "Unhide all of the protection stone blocks in the world you are in.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin cleanup remove [days] [world (console)]", "Remove inactive players that haven't joined within the last [days] days from protected regions in the world you are in (or specified). Then, remove any regions with no owners left.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin cleanup disown [days] [world (console)]", "Remove inactive players that haven't joined within the last [days] days from protected regions in the world you are in (or specified).");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin flag [world] [flag] [value|null|default]", "set a flag for all protection stone regions in a world.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin lastlogon [player]", "Get the last time a player logged on.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin lastlogons", "List all of the last logons of each player.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin stats [player (optional)]", "Show some statistics of the plugin.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin recreate", "Recreate all PS regions using radius set in config.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin settaxautopayers", "Add a tax autopayer for every region on the server that does not have one.");
        send(p, ArgAdmin.FORCEMERGE_HELP, "Merge overlapping PS regions together if they have the same owners, members and flags.");
        send(p, ArgAdmin.CHANGEBLOCK_HELP, "Change all of the PS blocks in a region to a different block. Both blocks must be configured in config.");
        send(p, ChatColor.AQUA + "> " + ChatColor.GRAY + "/ps admin fixregions", "Use this command to correct errors for all of the PS regions in a world. Useful if you have issues with the plugin.");

        return true;
    }
}

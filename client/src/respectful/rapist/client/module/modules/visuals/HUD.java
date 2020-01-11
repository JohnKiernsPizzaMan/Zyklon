package respectful.rapist.client.module.modules.visuals;

import respectful.rapist.client.EventManager;
import respectful.rapist.client.mapping.Mappings;
import respectful.rapist.client.module.Module;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HUD extends Module {
    public HUD() {
        super(200, "HUD", "FF0000");
    }

    @Override
    public void onRenderGUI() {
        Mappings.FontRenderer.drawStringWithShadow(Mappings.Minecraft.getFontRenderer(), "Zyklon", 3, 3, "8DC63F");
        Mappings.FontRenderer.drawStringWithShadow(Mappings.Minecraft.getFontRenderer(), new SimpleDateFormat("h:mm a").format(Calendar.getInstance().getTime()), Mappings.FontRenderer.getStringWidth(Mappings.Minecraft.getFontRenderer(), "Zyklon") + 6, 3, "FFFFFF");
        int mult = 0;
        for (Module module : EventManager.moduleManager.modules) {
            if (module.enabled && !module.equals(this)) {
                Mappings.FontRenderer.drawStringWithShadow(Mappings.Minecraft.getFontRenderer(), module.name, Mappings.ScaledResolution.getScaledWidth(Mappings.ScaledResolution.newInstance(Mappings.Minecraft.getMinecraft(), Mappings.Minecraft.getDisplayWidth(), Mappings.Minecraft.getDisplayHeight())) - Mappings.FontRenderer.getStringWidth(Mappings.Minecraft.getFontRenderer(), module.name) - 3, 3 + (mult * 10), module.color);
                mult++;
            }
        }
    }
}
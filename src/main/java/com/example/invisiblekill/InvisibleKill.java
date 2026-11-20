package com.example.invisiblekill;

import net.fabricmc.api.ModInitializer;

public final class InvisibleKill implements ModInitializer {
    public static final String MOD_ID = "invisiblekill";

    @Override
    public void onInitialize() {
        // Death-message handling is installed by CombatTrackerMixin.
    }
}

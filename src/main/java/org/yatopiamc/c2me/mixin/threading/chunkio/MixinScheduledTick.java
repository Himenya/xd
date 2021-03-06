package org.yatopiamc.c2me.mixin.threading.chunkio;

import net.minecraft.world.NextTickListEntry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.atomic.AtomicLong;

@Mixin(NextTickListEntry.class)
public class MixinScheduledTick {

    @Mutable
    @Shadow @Final private long c;
    private static final AtomicLong COUNTER = new AtomicLong(0);

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(CallbackInfo info) {
        this.c = COUNTER.getAndIncrement();
    }

}

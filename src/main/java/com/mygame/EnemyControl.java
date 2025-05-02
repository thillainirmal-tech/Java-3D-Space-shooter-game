package com.mygame;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class EnemyControl extends AbstractControl {
    private float speed = 5f;
    private final AssetManager assetManager;
    private final ExplosionEffect explosionEffect;

    public EnemyControl(AssetManager assetManager, ExplosionEffect explosionEffect) {
        this.assetManager = assetManager;
        this.explosionEffect = explosionEffect;
    }

    @Override
    protected void controlUpdate(float tpf) {
        spatial.move(0, 0, -speed * tpf);
        if (spatial.getLocalTranslation().z < -50) {
            spatial.removeFromParent();
        }
    }

    @Override
    protected void controlRender(com.jme3.renderer.RenderManager rm, com.jme3.renderer.ViewPort vp) {}
}

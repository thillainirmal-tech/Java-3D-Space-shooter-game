package com.mygame;

import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class LaserControl extends AbstractControl {
    private float speed = 20f;

    @Override
    protected void controlUpdate(float tpf) {
        spatial.move(0, 0, speed * tpf);
        if (spatial.getLocalTranslation().z > 50) {
            spatial.removeFromParent();
        }
    }

    @Override
    protected void controlRender(com.jme3.renderer.RenderManager rm, com.jme3.renderer.ViewPort vp) {}
}

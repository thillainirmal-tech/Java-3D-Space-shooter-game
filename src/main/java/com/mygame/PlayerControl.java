package com.mygame;

import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.KeyInput;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.Spatial;
import com.jme3.math.Vector3f;

public class PlayerControl extends AbstractControl implements ActionListener {
    private InputManager inputManager;
    private float speed = 10f;
    private boolean left, right;

    public PlayerControl(InputManager inputManager) {
        this.inputManager = inputManager;
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addListener(this, "Left", "Right");
    }

    @Override
    protected void controlUpdate(float tpf) {
        if (spatial != null) {
            Vector3f loc = spatial.getLocalTranslation();
            if (left) loc.x -= speed * tpf;
            if (right) loc.x += speed * tpf;
            spatial.setLocalTranslation(loc);
        }
    }

    @Override
    protected void controlRender(com.jme3.renderer.RenderManager rm, com.jme3.renderer.ViewPort vp) {}

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals("Left")) left = isPressed;
        if (name.equals("Right")) right = isPressed;
    }
}

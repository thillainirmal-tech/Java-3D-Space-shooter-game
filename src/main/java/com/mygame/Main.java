package com.mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.scene.Spatial;
import com.jme3.scene.Node;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.KeyInput;
import com.jme3.audio.AudioNode;
import com.jme3.audio.AudioData;
import com.jme3.math.Vector3f;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;

public class Main extends SimpleApplication {

    private Spatial spaceship;
    private ExplosionEffect explosionEffect;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        // Lighting
        DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White);
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);

        // Load spaceship
        spaceship = assetManager.loadModel("Models/spaceship.j3o");
        spaceship.setLocalScale(1.5f);
        spaceship.setLocalTranslation(0, 0, 0);
        spaceship.addControl(new PlayerControl(inputManager));
        rootNode.attachChild(spaceship);

        // Explosion utility
        explosionEffect = new ExplosionEffect(assetManager);

        // Input mapping for shooting
        inputManager.addMapping("Shoot", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(actionListener, "Shoot");

        // Game logic
        stateManager.attach(new GameManager(rootNode, assetManager, explosionEffect));

        flyCam.setMoveSpeed(50);
        cam.setLocation(new Vector3f(0, 10, -20));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
    }

    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            if (name.equals("Shoot") && !keyPressed) {
                Spatial laser = assetManager.loadModel("Models/laser.j3o");
                laser.setLocalTranslation(spaceship.getLocalTranslation().add(0, 0, 1));
                laser.addControl(new LaserControl());
                rootNode.attachChild(laser);

                AudioNode laserSound = new AudioNode(assetManager, "Sounds/laser_shot.ogg", AudioData.DataType.Buffer);
                laserSound.setVolume(2);
                laserSound.setPositional(false);
                laserSound.playInstance();
            }
        }
    };
}

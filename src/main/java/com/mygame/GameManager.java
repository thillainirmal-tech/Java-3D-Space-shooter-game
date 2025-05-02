package com.mygame;

import com.jme3.app.state.AbstractAppState;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Spatial;
import com.jme3.scene.Node;
import com.jme3.math.Vector3f;

public class GameManager extends AbstractAppState {
    private final Node rootNode;
    private final AssetManager assetManager;
    private final ExplosionEffect explosionEffect;
    private float timer = 0;

    public GameManager(Node rootNode, AssetManager assetManager, ExplosionEffect explosionEffect) {
        this.rootNode = rootNode;
        this.assetManager = assetManager;
        this.explosionEffect = explosionEffect;
    }

    @Override
    public void update(float tpf) {
        timer += tpf;
        if (timer >= 3f) {
            Spatial enemy = assetManager.loadModel("Models/enemy_ship.j3o");
            enemy.setLocalTranslation((float) (Math.random() * 10 - 5), 0, 20);
            enemy.addControl(new EnemyControl(assetManager, explosionEffect));
            rootNode.attachChild(enemy);
            timer = 0;
        }
    }
}

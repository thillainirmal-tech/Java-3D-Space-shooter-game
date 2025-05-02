package com.mygame;

import com.jme3.audio.AudioData;
import com.jme3.audio.AudioNode;
import com.jme3.asset.AssetManager;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;

public class ExplosionEffect {
    private final AssetManager assetManager;

    public ExplosionEffect(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public Node createExplosion(Vector3f location) {
        Node explosionNode = new Node("Explosion");

        ParticleEmitter emitter = new ParticleEmitter("Explosion", ParticleMesh.Type.Triangle, 30);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Particle.j3md");
        mat.setTexture("Texture", assetManager.loadTexture("Effects/Explosion.png"));
        emitter.setMaterial(mat);
        emitter.setImagesX(2);
        emitter.setImagesY(2);
        emitter.setEndColor(ColorRGBA.Red);
        emitter.setStartColor(ColorRGBA.Yellow);
        emitter.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 2, 0));
        emitter.setStartSize(1.5f);
        emitter.setEndSize(0.1f);
        emitter.setGravity(0, 0, 0);
        emitter.setLowLife(1f);
        emitter.setHighLife(2f);
        emitter.getParticleInfluencer().setVelocityVariation(1f);

        emitter.setLocalTranslation(location);
        explosionNode.attachChild(emitter);
        emitter.emitAllParticles();

        AudioNode explosionSound = new AudioNode(assetManager, "Sounds/explosion.ogg", AudioData.DataType.Buffer);
        explosionSound.setVolume(3);
        explosionSound.setPositional(false);
        explosionSound.playInstance();

        explosionNode.attachChild(explosionSound);
        return explosionNode;
    }
}

package com.mygdx.revive.effects;

import com.mygdx.revive.Renderable;
import com.mygdx.revive.World;
import com.mygdx.revive.location.Location;
import com.mygdx.revive.location.Vector2D;
import com.badlogic.gdx.graphics.Color;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TextIndicator implements Effect, Renderable {

    public World world;
    public List<TextItem> items = new CopyOnWriteArrayList<>();

    public static class TextItem {
        private final Location location;
        private final Location destination;
        private final long created;
        private final long duration;
        private final String text;
        private float fraction = 0;
        private float speed = 3F;
        private final Color color;

        public TextItem(Location location, Vector2D offset, long duration, String text, float speed, Color color) {
            this.location = location;
            this.destination = new Location(this.location).add(offset);
            this.duration = duration;
            this.created = System.currentTimeMillis();
            this.text = text;
            this.speed = speed;
            this.color = color;
        }

        public Location getLocation() {
            return location;
        }

        public long getDuration() {
            return duration;
        }

        public String getText() {
            return text;
        }

        public long getCreated() {
            return created;
        }

        public float getSpeed() {
            return speed;
        }

        public Color getColor() {
            return color;
        }
    }

    public List<TextItem> getItems() {
        return items;
    }

    public void createText(Location location, Vector2D offset, String text, long duration, float speed, Color color) {
        this.items.add(new TextItem(location, offset, duration, text, speed, color));
    }
    public void createText(Location location, Vector2D offset, String text, long duration, float speed) {
        this.items.add(new TextItem(location, offset, duration, text, speed, Color.RED));
    }

    public TextIndicator(World world) {
        this.world = world;
    }

    @Override
    public void create(){}

    @Override
    public void render(){}

    @Override
    public void dispose(){}
}

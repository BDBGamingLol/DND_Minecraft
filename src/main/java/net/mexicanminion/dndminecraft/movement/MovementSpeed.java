package net.mexicanminion.dndminecraft.movement;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class MovementSpeed {

	int mainXPoint;
	int mainZPoint;
	int currentXPoint;
	int currentZPoint;
	int oldXPoint;
	int oldZPoint;
	int speed;
	PlayerEntity player;

	public MovementSpeed(int speed, PlayerEntity player) {
		this.speed = speed;
		this.player = player;
	}

	public void setMain(Vec3d playerPos) {
		this.mainXPoint = (int)(playerPos.x);
		this.mainZPoint = (int)(playerPos.z);
		currentXPoint = mainXPoint;
		currentZPoint = mainZPoint;
	}

	public void updatePos(PlayerEntity player) {
		if ((int) player.getX() != currentXPoint || (int)player.getZ() != currentZPoint) {
			oldXPoint = currentXPoint;
			oldZPoint = currentZPoint;
			currentXPoint = (int) player.getX();
			currentZPoint = (int)player.getZ();
		}
	}

	public int getMovement() {
		int movement;
		int x = Math.abs(Math.abs(currentXPoint) - Math.abs(mainXPoint));
		int z = Math.abs(Math.abs(currentZPoint) - Math.abs(mainZPoint));

		movement = x + z;
		return movement;
	}

	public void checkMovement() {
		player.sendMessage(Text.literal("Movement: " + getMovement()), false);
		player.sendMessage(Text.literal("Curr X: " + currentXPoint), false);
		player.sendMessage(Text.literal("Curr Y: " + currentZPoint), false);
		if (getMovement() > speed) {
			if(oldXPoint < 0 || oldZPoint < 0)
				player.teleport(oldXPoint, player.getY(), oldZPoint);
			else if(oldXPoint > 0 || oldZPoint > 0)
				player.teleport(oldXPoint, player.getY(), oldZPoint);

			updatePos(player);
		}else {
			updatePos(player);
		}
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}

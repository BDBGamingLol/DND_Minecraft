package net.mexicanminion.dndminecraft.movement;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class MovementSpeed {

	int mainXPoint;
	int mainZPoint;
	int currentXPoint;
	int currentZPoint;
	int oldXPoint;
	int oldZPoint;
	int speed;
	private boolean resetMovementFlag = true;
	PlayerEntity player;

	public MovementSpeed(int speed, PlayerEntity player) {
		this.speed = speed;
		this.player = player;
	}

	public void setMain(BlockPos playerPos) {
		this.mainXPoint = playerPos.getX();
		this.mainZPoint = playerPos.getZ();
		currentXPoint = mainXPoint;
		currentZPoint = mainZPoint;
		oldXPoint = mainXPoint;
		oldZPoint = mainZPoint;
		if(resetMovementFlag) {
			resetMovementFlag = false;
		}
	}

	public void updatePos(PlayerEntity player) {
		int liveX = player.getBlockX();
		int liveZ = player.getBlockZ();
		if (liveX != currentXPoint || liveZ != currentZPoint) {
			oldXPoint = currentXPoint;
			oldZPoint = currentZPoint;
			currentXPoint = liveX;
			currentZPoint = liveZ;
		}
	}

	public int getMovement() {
		int movement;
		int x = Math.abs(currentXPoint - mainXPoint);
		int z = Math.abs(currentZPoint - mainZPoint);

		movement = x + z;
		return movement;
	}

	public void checkMovement() {
		updatePos(player);
		player.sendMessage(Text.literal("Movement: " + getMovement()), false);
		if (getMovement() > speed)
			player.teleport(oldXPoint + 0.5, player.getY(), oldZPoint + 0.5);
		resetMovementFlag = true;
	}

	public void resetMovement() {
		if(resetMovementFlag)
			setMain(player.getBlockPos());
		player.teleport(oldXPoint + 0.5, player.getBlockY(), oldZPoint + 0.5);
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}

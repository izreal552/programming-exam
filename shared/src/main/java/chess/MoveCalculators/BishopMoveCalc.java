package chess.MoveCalculators;

import chess.*;

import java.util.HashSet;

public class BishopMoveCalc {
    public static HashSet<ChessMove> getMove(ChessBoard board, ChessPosition position){
        int xPos = position.getColumn();
        int yPos = position.getRow();
        int[][] possibleMoves = {{1,1}, {1,-1}, {-1,1}, {-1,-1}};
        ChessGame.TeamColor teamColor = board.getPiece(position).getTeamColor();

        return MoveCalc.directionalMovement(board, position, possibleMoves, yPos, xPos, teamColor);
    }

}

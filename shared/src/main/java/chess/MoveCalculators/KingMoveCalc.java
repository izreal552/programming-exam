package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.HashSet;

public class KingMoveCalc {
    public static HashSet<ChessMove> getMove(ChessBoard board, ChessPosition position){
        int xPos = position.getColumn();
        int yPos = position.getRow();
        int[][] possibleMoves = {{1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,1}, {0,-1}, {1,0}, {-1,0}};
        ChessGame.TeamColor teamColor = board.getPiece(position).getTeamColor();

        return MoveCalc.singleMovement(board, position, possibleMoves, yPos, xPos, teamColor);
    }
}

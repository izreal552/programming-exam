package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.HashSet;

public class KnightMoveCalc {
    public static HashSet<ChessMove> getMove(ChessBoard board, ChessPosition position){
        int xPos = position.getColumn();
        int yPos = position.getRow();
        int[][] possibleMoves = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};
        ChessGame.TeamColor teamColor = board.getPiece(position).getTeamColor();

        return MoveCalc.singleMovement(board, position, possibleMoves, yPos, xPos, teamColor);
    }
}

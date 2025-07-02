package chess.MoveCalculators;

import chess.*;

import java.util.HashSet;

public class PawnMoveCalc {
    public static HashSet<ChessMove> getMove(ChessBoard board, ChessPosition position){
        int xPos = position.getColumn();
        int yPos = position.getRow();
        ChessGame.TeamColor teamColor = board.getPiece(position).getTeamColor();
        ChessPiece.PieceType[] promotionPiece = new ChessPiece.PieceType[]{null};

        int movement;
        if(teamColor == ChessGame.TeamColor.WHITE){
            movement = 1;
        }
        else{
            movement = -1;
        }

        boolean promote = (teamColor == ChessGame.TeamColor.WHITE && yPos == 7) ||
                (teamColor == ChessGame.TeamColor.BLACK && yPos == 2);
        if(promote){
            promotionPiece = new ChessPiece.PieceType[]{ChessPiece.PieceType.ROOK, ChessPiece.PieceType.BISHOP,
            ChessPiece.PieceType.KNIGHT, ChessPiece.PieceType.QUEEN};
        }

        boolean start = (teamColor == ChessGame.TeamColor.WHITE && yPos == 2) ||
                (teamColor == ChessGame.TeamColor.BLACK && yPos == 7);

        HashSet<ChessMove> moves = new HashSet<>();
        for(ChessPiece.PieceType promotion:promotionPiece){
            ChessPosition forwardMovement = new ChessPosition(yPos + movement, xPos);
            ChessPosition doubleMovement = new ChessPosition(yPos + movement * 2, xPos);
            ChessPosition rightCapture = new ChessPosition(yPos + movement, xPos + 1);
            ChessPosition leftCapture = new ChessPosition(yPos + movement, xPos - 1);

            if(MoveCalc.isValid(doubleMovement) &&
                    start &&
                    board.getPiece(doubleMovement) == null &&
                    board.getPiece(forwardMovement) == null ){
                moves.add(new ChessMove(position, doubleMovement, promotion));
            }
            if(MoveCalc.isValid(forwardMovement) && board.getPiece(forwardMovement) == null){
                moves.add(new ChessMove(position, forwardMovement, promotion));
            }
            if(MoveCalc.isValid(rightCapture) &&
                    board.getPiece(rightCapture) != null &&
                    board.getPiece(rightCapture).getTeamColor() != teamColor){
                moves.add(new ChessMove(position, rightCapture, promotion));
            }
            if(MoveCalc.isValid(leftCapture) &&
                    board.getPiece(leftCapture) != null &&
                    board.getPiece(leftCapture).getTeamColor() != teamColor){
                moves.add(new ChessMove(position, leftCapture, promotion));
            }
        }
        return moves;
    }
}

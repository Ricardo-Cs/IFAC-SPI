import express from "express";
import jwt from "jsonwebtoken";

const router = express.Router();
const JWT_SECRET = "12345";

const users = [
  { id: 1, username: "alice", email: "alice@email.com", pass: "123" },
  { id: 2, username: "bob", email: "bob@email.com", pass: "123" },
];

const auth = (req, res, next) => {
  const token = req.headers.authorization?.split(" ")[1];
  try {
    req.user = jwt.verify(token, JWT_SECRET);
    next();
  } catch {
    res.status(401).json({ error: "Token inválido ou ausente" });
  }
};

router.post("/login", (req, res) => {
  const { username, password } = req.body;
  const user = users.find((u) => u.username === username && u.pass === password);

  if (!user) return res.status(401).json({ error: "Credenciais inválidas" });

  const token = jwt.sign({ id: user.id }, JWT_SECRET);
  res.json({ token, userId: user.id });
});

router.get("/users/:id", auth, (req, res) => {
  const user = users.find((u) => u.id === Number(req.params.id));

  if (!user) return res.status(404).json({ error: "Usuário não encontrado" });

  res.json(user);
});

export default router;

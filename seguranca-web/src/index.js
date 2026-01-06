import express from "express";
import path from "path";
import { fileURLToPath } from "url";
import routes from "./routes.js";

const app = express();
const __dirname = path.dirname(fileURLToPath(import.meta.url));

app.use(express.json());

app.use(express.static(path.join(__dirname, "view")));

app.use("/api", routes);

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Servidor rodando em http://localhost:${PORT}`);
});

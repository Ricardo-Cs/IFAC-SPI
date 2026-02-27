import { Module } from '@nestjs/common';
import { HttpModule } from '@nestjs/axios';
import { PythonService } from './python.service';
import { PythonController } from './python.controller';

@Module({
    imports: [HttpModule],
    providers: [PythonService],
    controllers: [PythonController],
})
export class PythonModule { }
